import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findAndReplace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            String startString = br.readLine();
            String endString = br.readLine();
            List<Character> startList = new ArrayList<>();
            List<Character> endList = new ArrayList<>();
            startString.chars().forEach(e -> startList.add((char) e));
            endString.chars().forEach(e -> endList.add((char) e));
            Set<Character> startSet = new HashSet<>(startList);
            Set<Character> endSet = new HashSet<>(endList);

            if (startString.equals(endString)) System.out.println(0);
            else if (startSet.size() < endSet.size()) System.out.println(-1);
            else {
                System.out.println(calculateReplace(startString, endString, startList, endList, startSet, endSet));
            }
        }
    }

    static int calculateReplace(String startString, String endString, List<Character> startList, List<Character> endList, Set<Character> startSet, Set<Character> endSet) {
        // make a difference list
        List<Character> diffListStart = new ArrayList<>();
        List<Character> diffListEnd = new ArrayList<>();
        for(int i = 0; i < startString.length(); i++) {
            if(startList.get(i) != endList.get(i)) {
                diffListStart.add(startList.get(i));
                diffListEnd.add(endList.get(i));
            }
        }

        // use difference list to identify anomalies
        // create hashset of difference list
        Set<Character> diffSetStart = new HashSet<>(diffListStart);
        Set<Character> diffSetEnd = new HashSet<>(diffListEnd);

        // check if diff chars are aligned with mismatched chars
        Character[] diffIterator = new Character[diffSetStart.size()];
        Character[] diffIteratorEnd = new Character[diffSetEnd.size()];
        diffSetStart.toArray(diffIterator);
        diffSetEnd.toArray(diffIteratorEnd);
        for(int j = 0; j < diffIterator.length; j++) {
            for(int i = 0; i < startString.length(); i++) {
                if ((startString.charAt(i) == diffIterator[j]) && ((startString.charAt(i) == endString.charAt(i)))) {
                    // exit out of loop, impossible
                    return -1;
                }
            }
        }

        // all mismatching characters should be aligned
        // check for how many cycles
        int num = diffSetStart.size(); // how many cycles there are
        int result = 0;
        int cyclesResult = 0;
        // recursion to find cycles
        List<Integer> numStart = new ArrayList<>();
        int pointer = 0;
        boolean isRunningCycle = true;
        int startIndex = 0;
        while(diffListEnd.size() > 0) {
            numStart.add(pointer);
            // run through the cycle
            if(isRunningCycle) {
                System.out.println("bitch " + pointer);
                if (diffSetStart.contains(diffListEnd.get(pointer))) {
                    pointer = diffListStart.indexOf(diffListEnd.get(pointer));
                    if (pointer == startIndex) {
                        // cycle found
                        cyclesResult += numStart.size();
                        for (int m = 0; m < numStart.size(); m++) {
                            if(numStart.get(m) > numStart.get(Math.max(0, m-1))){
                                diffListStart.remove(numStart.get(m)-m);
                                diffListEnd.remove(numStart.get(m)-m);
                            } else {
                                diffListStart.remove(numStart.get(m).intValue());
                                diffListEnd.remove(numStart.get(m).intValue());
                            }
                        }
                        numStart.clear();
                        isRunningCycle = false;
                    }
                } else {
                    // no cycle found, cut it off
                    result += numStart.size();
                    for (int m = 0; m < numStart.size(); m++) {
                        if(numStart.get(m) > numStart.get(Math.max(0, m-1))){
                            diffListStart.remove(numStart.get(m)-m);
                            diffListEnd.remove(numStart.get(m)-m);
                        } else {
                            diffListStart.remove(numStart.get(m).intValue());
                            diffListEnd.remove(numStart.get(m).intValue());
                        }
                    }
                    numStart.clear();
                    isRunningCycle = false;
                }
            } else {
                if (pointer <= diffListEnd.size() - 1) {
                    pointer = 0;
                    isRunningCycle = true;
                    startIndex = 0;
                } else {
                    break;
                }
            }
        }


        // theoretically should only have cycles to compute if i didn't mess up
        if(cyclesResult > 0) {
            if(cyclesResult == 52) {
                return -1;
            } else {
                result += cyclesResult + 1;
            }
        }
        return result;
    }
}
