/*
ID: tiggerb1
LANG: JAVA
TASK: palsquare
*/

import java.util.*;
import java.io.*;

public class palsquare {
    static int A = (int) 'A';
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int B = Integer.parseInt(f.readLine());

        String sqrB;
        for(int i = 1; i <= 300; i++) {
            sqrB = convert(i*i, B);
            if(isPal(sqrB)) {
                pw.println(convert(i, B) + " " + sqrB);
            }
        }

        f.close();
        pw.close();
    }

    static String convert(int num, int B) {
        int digit = 0;
        StringBuilder result = new StringBuilder();
        // find largest place
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
            if(temp > 9) {
                result.append((char) ((temp-10)+A));
            } else {
                result.append(temp);
            }
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