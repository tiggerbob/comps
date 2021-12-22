/*
ID: tiggerb1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int N = Integer.parseInt(f.readLine());
        // 0: start; 1: end
        int[][] farmers = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            farmers[i][0] = Integer.parseInt(st.nextToken());
            farmers[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(farmers, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int maxLonely = 0;
        int a = farmers[0][0];
        int b = farmers[0][1];
        int maxMilked = b-a;

        for(int i = 0; i < N; i++) {
            if(farmers[i][1] > b && farmers[i][0] <= b) {
                b = farmers[i][1];
            } else if(farmers[i][0] > b) {
                maxMilked = Math.max(maxMilked, b-a);
                maxLonely = Math.max(farmers[i][0] - b, maxLonely);
                a = farmers[i][0];
                b = farmers[i][1];
            }
        }

        pw.println(maxMilked + " " + maxLonely);

        f.close();
        pw.close();
    }
}