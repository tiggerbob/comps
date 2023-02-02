import java.io.*;
import java.util.*;

public class Herding {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("herding.out"));

        StringTokenizer t = new StringTokenizer(f.readLine());
        int[] c = new int[3];
        for (int i = 0; i < 3; i++) {
            c[i] = Integer.parseInt(t.nextToken());
        }

        int min = 0;
        int max = 0;

        Arrays.sort(c);

        if (!(c[1]-c[0] == 1 && c[2]-c[1] == 1)) {
            if (c[2] - c[1] > c[1] - c[0]) {
                max = c[2] - c[1] - 1;
            } else {
                max = c[1] - c[0] - 1;
            }

            if (c[2]-c[1] == 2 || c[1]-c[0] == 2) {
                min = 1;
            } else {
                min = 2;
            }
        }

        pw.println(min);
        pw.println(max);

        pw.close();
    }
}