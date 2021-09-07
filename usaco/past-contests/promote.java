import java.io.*;
import java.util.*;

public class promote {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        StringTokenizer tokenizer = new StringTokenizer(f.readLine());
        int b0 = Integer.parseInt(tokenizer.nextToken());
        int b1 = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(f.readLine());
        int s0 = Integer.parseInt(tokenizer.nextToken());
        int s1 = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(f.readLine());
        int g0 = Integer.parseInt(tokenizer.nextToken());
        int g1 = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(f.readLine());
        int p0 = Integer.parseInt(tokenizer.nextToken());
        int p1 = Integer.parseInt(tokenizer.nextToken());

        int ans0 = p1-p0, ans1 = g1-g0 + ans0, ans2 = s1-s0 + ans1;

        out.println(ans2);
        out.println(ans1);
        out.print(ans0);

        out.close();
        f.close();
    }
}
