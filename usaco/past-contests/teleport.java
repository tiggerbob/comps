import java.io.*;
import java.util.*;

/*
ID: tigger
LANG: JAVA
TASK: teleport
*/

public class teleport {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
        StringTokenizer tok = new StringTokenizer(f.readLine(), " ");

        int a = Integer.parseInt(tok.nextToken());
        int b = Integer.parseInt(tok.nextToken());
        int x = Integer.parseInt(tok.nextToken());
        int y = Integer.parseInt(tok.nextToken());

        int ans = Math.abs(Math.min(x, y)-Math.min(a, b)) + Math.abs(Math.max(x, y)-Math.max(a, b));
        int orig = Math.abs(b-a);

        out.print(Math.min(orig, ans));
	out.close();
	f.close();
    }
}
