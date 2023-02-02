import java.io.*;
import java.util.*;

public class Gifts {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());
        int[][] lists = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] list = f.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                lists[i][j] = Integer.parseInt(list[j]);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
//        boolean[] certainty = new boolean[n];
        ArrayList<List<Integer>> poss = new ArrayList<List<Integer>>();
        int[] count = new int[n];

        ArrayList<Integer> poss0;
        for(int i = 0; i < n; i++) {
            poss0 = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                if(lists[i][j] != i+1) {
                    poss0.add(lists[i][j]);
                    count[lists[i][j] - 1]++;
                } else {
                    poss0.add(i + 1);
                    count[i]++;
                    break;
                }
            }

            if(poss0.size() == 1) {
                result.add(poss0.get(0));
            } else {
                for(int j = 0; j < n; j++) {
                    if (!result.contains(poss0.get(j))) {
                        result.add(poss0.get(j));
                        break;
                    }
                    for(int m = 0; m < poss0.size(); m++) {
                        int check = poss0.get(m);
                        if (!(count[check-1] > 1)) {
                            result.add(check);
                            j = n;
                            break;
                        }
                    }
                }
            }
            poss.add(poss0);
        }

        for (int gift :
                result) {
            System.out.println(gift);
        }
    }
}