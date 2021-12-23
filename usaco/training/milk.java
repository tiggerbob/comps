/*
ID: tiggerb1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {
    static class Farmer {
        int p;
        int a;
        public Farmer(int _p, int _a) { p = _p; a = _a; }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Farmer> farmers = new ArrayList<Farmer>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            Farmer farmer = new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            farmers.add(farmer);
        }

        farmers.sort(new Comparator<Farmer>() {
            public int compare(Farmer a, Farmer b) {
                return Integer.compare(a.p, b.p);
            }
        });

        int total = 0;

        while (N > 0) {
            if(farmers.get(0).a < N) {
                // not enough milk
                total += (farmers.get(0).a * farmers.get(0).p);
                N -= farmers.get(0).a;
                farmers.remove(0);
            } else {
                // either enough or too much milk
                total += (N*farmers.get(0).p);
                N -= N;
            }
        }

        pw.println(total);

        pw.close();
        f.close();
    }
}