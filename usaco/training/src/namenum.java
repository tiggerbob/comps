/*
ID: tiggerb1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

public class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String num = f.readLine();
        int N = num.length();

        f = new BufferedReader(new FileReader("dict.txt"));

        final char[][] keypad = {
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y'}
        };

        String name;
        boolean found = false;
        while((name = f.readLine()) != null) {
            if(name.length() == N) {
                boolean[] check = new boolean[N];
                for(int i = 0; i < N; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (keypad[Integer.parseInt(String.valueOf(num.charAt(i))) - 2][j] == name.charAt(i)) {
                            check[i] = true;
                        }
                    }
                }
                boolean result = true;
                for (boolean digit :
                        check) {
                    if(!digit) result = false;
                }
                if(result) {
                    found = true;
                    pw.println(name);
                }
            }
        }

        if(!found) pw.println("NONE");
        f.close();
        pw.close();
    }
}