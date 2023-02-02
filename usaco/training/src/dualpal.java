/*
ID: tiggerb1
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.io.*;

public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) + 1;

        int found = 0;
        boolean a = false, b = false;
        while(true) {
            for(int i = 2; i <= 10; i++) {
                if(isPal(convert(S, i))) {
                    if(!a) {
                        a = true;
                    } else {
                        b = true;
                        break;
                    }
                }
            }
            if(a && b) {
                found++;
                pw.println(S);
                if(found == N) break;
            }
            S++;
            a = false;
            b = false;
        }

        f.close();
        pw.close();
    }

    static String convert(int num, int B) {
        int digit = 0;
        StringBuilder result = new StringBuilder();
        while(num > Math.pow(B, digit)) {
            digit++;
        }
        if(num == Math.pow(B, digit)) {
            result = new StringBuilder("1");
            for(int i = 0; i < digit; i++) {
                result.append("0");
            }
            return result.toString();
        }

        digit--;
        while (digit > -1) {
            int temp = B - 1;
            for (int i = 0; i < B; i++) {
                if (Math.pow(B, digit) * i > num) {
                    temp = i - 1;
                    break;
                }
            }
            result.append(temp);
            num -= Math.pow(B, digit) * temp;
            digit--;
        }

        return result.toString();
    }

    static boolean isPal(String str) {
        StringBuilder check = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            check.append(str.charAt(i));
        }
        return check.toString().equals(str);
    }
}