/*
ID: tiggerb1
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.*;

public class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int N = Integer.parseInt(f.readLine());

        char[][] orig = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] line = f.readLine().toCharArray();
            orig[i] = line;
        }
        char[][] result = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] line = f.readLine().toCharArray();
            result[i] = line;
        }

        int out = 7;

        if(Arrays.deepEquals(result, testOne(orig, N))) out = 1;
        else if(Arrays.deepEquals(result, testTwo(orig, N))) out = 2;
        else if(Arrays.deepEquals(result, testThree(orig, N))) out = 3;
        else if(Arrays.deepEquals(result, testFour(orig, N))) out = 4;
        else if(Arrays.deepEquals(result, testOne(testFour(orig, N), N))) out = 5;
        else if(Arrays.deepEquals(result, testTwo(testFour(orig, N), N))) out = 5;
        else if(Arrays.deepEquals(result, testThree(testFour(orig, N), N))) out = 5;
        else if(Arrays.deepEquals(result, orig)) out = 6;

        pw.println(out);

        f.close();
        pw.close();
    }

    // rotate 90 deg
    static char[][] testOne(char[][] orig, int N) {
        char[][] result = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] column = new char[N];
            for(int j = N-1; j >= 0; j--) {
                column[(N-1)-j] = orig[j][i];
            }
            result[i] = column;
        }
        return result;
    }

    // rotate 180 degrees
    static char[][] testTwo(char[][] orig, int N) {
        char[][] result = new char[N][N];
        for (int i = N - 1; i >= 0; i--) {
            char[] row = new char[N];
            for (int j = N - 1; j >= 0; j--) {
                row[(N - 1) - j] = orig[i][j];
            }
            result[(N - 1) - i] = row;
        }
        return result;
    }

    // rotate 270 degrees
    static char[][] testThree(char[][] orig, int N) {
        char[][] result = new char[N][N];
        for (int i = N-1; i >= 0; i--) {
            char[] column = new char[N];
            for (int j = 0; j < N; j++) {
                column[j] = orig[j][i];
            }
            result[(N-1)-i] = column;
        }
        return result;
    }

    // reflection
    static char[][] testFour(char[][] orig, int N) {
        char[][] result = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] row = new char[N];
            for (int j = N-1; j >= 0; j--) {
                row[(N-1)-j] = orig[i][j];
            }
            result[i] = row;
        }
        return result;
    }

}