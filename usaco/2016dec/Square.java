import java.io.*;
import java.util.*;

public class Square {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("square.out"));

        StringTokenizer t = new StringTokenizer(f.readLine());
        int[] a = {Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken())};
        int[] b = {Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken())};
        t = new StringTokenizer(f.readLine());
        int[] c = {Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken())};
        int[] d = {Integer.parseInt(t.nextToken()), Integer.parseInt(t.nextToken())};



        int h = Math.max(b[1], d[1])-Math.min(a[1], c[1]);
        int l = Math.max(b[0], d[0])-Math.min(a[0], c[0]);

        pw.println((int) Math.pow(Math.max(h, l), 2));
        pw.close();
    }
}