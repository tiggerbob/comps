import java.io.*;
import java.util.*;

public class Dice {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(f.readLine());
        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];

        int aa = 0, bb = 0, cc = 0, cd = 0;
        boolean found;
        while (n > 0) {
            aa = 0;
            bb = 0;
            cc = 0;
            cd = 0;
            found = false;
            StringTokenizer t = new StringTokenizer(f.readLine());
            for(int i = 0; i < 4; i++) {
                a[i] = Integer.parseInt(t.nextToken());
            }
            for(int i = 0; i < 4; i++) {
                b[i] = Integer.parseInt(t.nextToken());
            }

            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (a[i] > b[j]) aa++;
                    if (b[i] > a[j]) bb++;
                }
            }

            if(bb > aa) {
                // swap so a is larger than b
                cc = bb;
                bb = aa;
                aa = cc;
                c = b;
                b = a;
                a = c;
            }

            c = new int[]{0, 0, 0, 0};

            for (int i = 1; i <= 10; i++) {
                c[0] = i;
                for (int j = 1; j <= 10; j++) {
                    c[1] = j;
                    for (int m = 1; m <= 10; m++) {
                        c[2] = m;
                        for (int u = 1; u <= 10; u++) {
                            // each test case 10000
                            c[3] = u;
                            aa = 0;
                            bb = 0;
                            cc = 0;
                            cd = 0;
                            for(int o = 0; o < 4; o++) {
                                for (int p = 0; p < 4; p++) {
                                    if (c[o] > a[p]) cc++;
                                    if (a[o] > c[p]) aa++;
                                }
                            }
                            for(int o = 0; o < 4; o++) {
                                for (int p = 0; p < 4; p++) {
                                    if (c[o] > b[p]) cd++;
                                    if (b[o] > c[p]) bb++;
                                }
                            }
                            found = (bb > cd && cc > aa);
                            if (found) {
                                i = 11;
                                j = 11;
                                m = 11;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(found ? "yes" : "no");
//            System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
            n--;
        }
    }
}