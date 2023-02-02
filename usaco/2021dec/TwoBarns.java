import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoBarns {
    public static int[] visited;
    public static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {

            StringTokenizer tokenizer = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            visited = new int[N];

            // MAKE EVERYTHING SUBTRACT 1 (start from 0)
            // alr initialized so don't worry abt it after this
            adj = new ArrayList<List<Integer>>();
            for(int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }
            for(int i = 0; i < M; i++) {
                    tokenizer = new StringTokenizer(f.readLine());
                    int a = Integer.parseInt(tokenizer.nextToken());
                    int b = Integer.parseInt(tokenizer.nextToken());
                    List<Integer> aTemp = adj.get(a-1);
                    aTemp.add(b-1);
                    adj.set(a-1, aTemp);

                    List<Integer> bTemp = adj.get(b-1);
                    bTemp.add(a-1);
                    adj.set(b-1, bTemp);
            }

            int ans = traverseFarms(0, N-1);
            System.out.println(ans);

        }
    }

    public static void dfs(int node, int color) {
        visited[node] = color;
        for(int u : adj.get(node))
            if(visited[u] == 0)
                dfs(u, color);
    }

    public static int traverseFarms(int startingNode, int N) {
        int color = 1;
        dfs(startingNode, color);
        if(visited[N] > 0) {
            return 0;
        } else {
            color++;
            // 1 is from start, 2 is from end
            dfs(N, color);
            for(int j = 0; j <= N; j++) {
                if(visited[j] == 0) {
                    color++;
                    dfs(j, color);
                }
            }

            // everything has been initialized, find the smallest distance
            List<Integer> vA = new ArrayList<>();
            boolean tempA = false;
            boolean tempB = false;
            for (int o = 0; o < visited.length; o++) {
                int u = visited[o];
                // find all vertices of color 1
                if(u == 1 && !tempA) {
                    tempA = true;
                } else if (u != 1 && tempA && !vA.contains(u-1)) {
                    tempA = false;
                    vA.add(o-1);
                }

                // find all vertices of color 2
                if(u == 2 && !tempB) {
                    tempB = true;
                } else if (u != 2 && tempB && !vA.contains(u-1)) {
                    tempB = false;
                    vA.add(o-1);
                }
            }

            // vertices initialized
            int runningTotal = N;
            int val = 0;
            int t = 0;
            for (Integer i : vA) {
                int ans = 0;
                val = i;
                t = 0;
                for (int p = val + 1; visited[p] != 1 && visited[p] != 2; p++) {
                    for(int y = p+1; y < visited.length; y++) {
                        if(visited[y] == t)  {
                            p = y;
                            break;
                        }
                    }
                    if (visited[p] != t) {
                        ans++;
                        t = visited[p];
                    }
                }
                runningTotal = Math.min(ans, runningTotal);
            }

            // check if possible shortcuts can be taken
            System.out.println(Arrays.toString(visited));
            return runningTotal+1;
        }
    }
}
