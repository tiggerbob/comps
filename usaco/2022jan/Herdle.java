import java.io.*;
import java.util.*;

public class Herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        char[][] a = new char[3][3];
        for(int i = 0; i < 3; i++) {
            a[i] = f.readLine().toCharArray();
        }

        char[][] g = new char[3][3];
        for(int i = 0; i < 3; i++) {
            g[i] = f.readLine().toCharArray();
        }

        int yellow = 0, green = 0;
        ArrayList<Integer> cds = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(a[i][j] == g[i][j]) {
                    green++;
                    cds.add((i*3)+j);
                }
            }
        }

        // each cell assigned location 0-8

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char guess = g[i][j];
//                System.out.println(guess);
                if (guess != a[i][j]) {
                    for (int u = 0; u < 3; u++) {
                        for (int s = 0; s < 3; s++) {
                            if (guess == a[u][s] && !cds.contains((u*3)+s)) {
//                                System.out.println(cds + " " + guess);
                                yellow++;
                                cds.add((u*3)+s);
                                u = 3;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(green);
        System.out.println(yellow);
    }
}