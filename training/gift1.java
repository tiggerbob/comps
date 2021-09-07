/*
ID: tiggerb1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String args[]) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int np = Integer.parseInt(f.readLine());
        String[] people = new String[np];
        for(int i = 0; i < np; i++) {
            people[i] = f.readLine();
        }
        
        int[] values = new int[np];

        for(int i = 0; i < np; i++) {
            String gifter = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int moneyVal = Integer.parseInt(st.nextToken());
            int receiverNum = Integer.parseInt(st.nextToken());
            if(moneyVal != 0) {
                values[Arrays.asList(people).indexOf(gifter)] -= moneyVal - (moneyVal % receiverNum);
            }
            for(int r = 0; r < receiverNum; r++) {
                if(moneyVal != 0) {
                    values[Arrays.asList(people).indexOf(f.readLine())] += (int) moneyVal/receiverNum;
                } else {
                    f.readLine();
                }
            }
        }

        for(int i = 0; i < np; i++) {
            out.println(people[i] + " " + values[i]);
        }

        out.close();
        f.close();
    }
}
