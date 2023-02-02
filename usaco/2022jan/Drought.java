import java.io.*;
import java.util.*;

public class Drought {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while (t > 0) {
            int j = Integer.parseInt(f.readLine());
            int[] c = new int[j];
            StringTokenizer token = new StringTokenizer(f.readLine());
            for (int i = 0; i < j; i++) {
                c[i] = Integer.parseInt(token.nextToken());
            }

            long result = 0;

            while (true) {
                if (j == 1) {
                    break;
                } else if (j == 2) {
                    if (c[0] != c[1]) {
                        result = -1;
                        break;
                    } else {
                        break;
                    }
                } else {
                    if (c[0] > c[1] || c[j-1] > c[j-2]) {
                        result = -1;
                        break;
                    }
                }

                int largest = c[0];
                int smallest = c[0];
                int diff = 0;
                boolean neg = false;
                boolean same = true;
                for (int i = 0; i < j; i++) {
                    if (c[i] > largest) largest = c[i];
                    if (i != 0 && c[i] != c[i-1]) {
                        same = false;
                    }
                    if (c[i] < 0) {
                        neg = true;
                        break;
                    }
                    if (c[i] < smallest) smallest = c[i];
                }
                if (same) {
                    break;
                }
                for (int i = 0; i < j; i++) {
                    if(c[i] == largest && i != 0 && i != j-1) {
                        int minadj = Math.min(c[i+1], c[i-1]);
                        if (minadj != c[i]) {
                            diff = c[i] - minadj;
                        } else {
                            diff = c[i] - smallest;
                        }
                        result += diff;
                        c[i] -= diff;
                        if (c[i+1] != c[i-1]) {
                            if (c[i+1] > c[i-1]) {
                                c[i+1] -= diff;
                            } else {
                                c[i-1] -= diff;
                            }
                        } else {
                            if (i + 1 == j) {
                                c[i+1] -= diff;
                            } else {
                                c[i-1] -= diff;
                            }
                        }
                        if (c[i] < 0 || c[i-1] < 0 || c[i+1] < 0) {
                            result = -1;
                            break;
                        }
//                        System.out.println(Arrays.toString(c));
                    }
                }

            }
            pw.println(result != -1 ? result*2 : -1);
            t--;
        }
        pw.close();
    }
}