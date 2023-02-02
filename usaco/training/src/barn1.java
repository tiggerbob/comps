/*
ID: tiggerb1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

public class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        // egg

        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] cows = new int[C];
        for(int i = 0; i < C; i++) {
            cows[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(cows);

        List<Integer> dif = new ArrayList<Integer>();
        for(int i = 0; i < C-1; i++) {
            dif.add(cows[i+1]-cows[i]);
        }

        Collections.sort(dif);
        
        int total = cows[cows.length-1] - cows[0]+1;
        int boards = 1;
        while(boards < M && dif.size() > 0) {
            total -= dif.get(dif.size()-1)-1;
            dif.remove(dif.size()-1);
            boards++;
        }

        pw.println(total);

        pw.close();
        f.close();
    }
}