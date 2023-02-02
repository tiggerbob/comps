"use strict";

/* global chrome */

const CLOSE_TAB = "CLOSE_TAB";
const SHOW_BLOCKED_INFO_PAGE = "SHOW_BLOCKED_INFO_PAGE";

const RESOLUTIONS = [
  CLOSE_TAB,
  SHOW_BLOCKED_INFO_PAGE,
];

chrome.runtime.onInstalled.addListener(function () {
  chrome.storage.local.get(["enabled", "blocked", "resolution"], function (local) {
    if (typeof local.enabled !== "boolean") {
      chrome.storage.local.set({ enabled: false });
    }

    if (!Array.isArray(local.blocked)) {
      chrome.storage.local.set({ blocked: [] });
    }

    if (!RESOLUTIONS.includes(local.resolution)) {
      chrome.storage.local.set({ resolution: CLOSE_TAB });
    }
  });
});

const __removeProtocol = (url) => url.replace(/^http(s?):\/\//, "");
const __removeWww = (url) => url.replace(/^www\./, "");
const __removeTrailingSlash = (url) => url.endsWith("/") ? url.slice(0, -1) : url;

const normalizeUrl = (url) => [url]
  .map(__removeProtocol)
  .map(__removeWww)
  .map(__removeTrailingSlash)
  .pop();

const getRules = (blocked) => {
  const allowList = blocked
    .filter((item) => item.startsWith("!"))
    .map((item) => normalizeUrl(item.substring(1)));

  const blockList = blocked
    .filter((item) => !item.startsWith("!"))
    .map(normalizeUrl);

  const rules = [
    ...allowList.map((path) => ({ path, type: "allow" })),
    ...blockList.map((path) => ({ path, type: "block" })),
  ].sort((a, b) => b.path.length - a.path.length); // rule specifitydsdfjldskj
  return rules;
};

chrome.tabs.onUpdated.addListener(function (tabId, changeInfo) {
  const url = changeInfo.pendingUrl || changeInfo.url;
  if (!url || !url.startsWith("http")) {
    return;
  }

  const normalizedUrl = normalizeUrl(url);

  chrome.storage.local.get(["enabled", "blocked", "resolution"], function (local) {
    const { enabled, blocked, resolution } = local;
    if (!enabled || !Array.isArray(blocked) || blocked.length === 0 || !RESOLUTIONS.includes(resolution)) {
      return;
    }

    const rules = getRules(blocked);
    const foundRule = rules.find((rule) => normalizedUrl.startsWith(rule.path) || normalizedUrl.endsWith(rule.path));
    if (!foundRule || foundRule.type === "allow") {
      return;
    }

    switch (resolution) {
    case CLOSE_TAB:
      chrome.tabs.remove(tabId);
      break;
    case SHOW_BLOCKED_INFO_PAGE:
      chrome.tabs.update(tabId, { url: `${chrome.runtime.getURL("blocked.html")}?url=${url}` });
      break;
    }
  });
});
