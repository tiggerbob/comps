/*
ID: tiggerb1
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.*;

public class wormhole {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("src/data/in.txt"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/data/out.txt")));

        int N = Integer.parseInt(f.readLine());
        int[][] wormholes = new int[N][2];

        StringTokenizer tokenizer;
        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(f.readLine());
            wormholes[i][0] = Integer.parseInt(tokenizer.nextToken());
            wormholes[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        // count y coord pairs
        // y value, number of coords
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            if(!h.containsKey(wormholes[i][1])) {
                h.put(wormholes[i][1], 1);
            } else {
                h.replace(wormholes[i][1], h.get(wormholes[i][1])+1);
            }
        }

        int total = 0;

        boolean has1 = false;
        boolean hasMultiple = false;

        // iterate through all y coord pairs
        for (Integer value :
                h.values()) {
            int count = 0;
            if(value != 1) {
                if(!has1){
                    has1 = true;
                } else {
                    if (!hasMultiple) hasMultiple = true;
                }
                if(total == 0) total = 1;
                count = 1;
                for(int i = value-1; i > 0; i-=2) {
                    count *= i;
                }
                total *= count;
            }
        }

        if(hasMultiple) total *= 2;

        pw.println(total);

        pw.close();
        f.close();
    }
}