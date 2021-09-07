import java.io.*;
import java.util.*;

/*
ID: tigger
LANG: JAVA
TASK: paint
*/

public class paint {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        String[] farmer = f.readLine().split(" ");
        String[] bessie = f.readLine().split(" ");

        int a = Integer.parseInt(farmer[0]);
        int b = Integer.parseInt(farmer[1]);
        int c = Integer.parseInt(bessie[0]);
        int d = Integer.parseInt(bessie[1]);

        System.out.println(a + " " + b + " " + c + " " + d);

        if ((a > c && a < d )|| (b > c && b < d) || a <= c && d <= b || c <= a && b <= d) out.print(Math.max(b, d)-Math.min(a, c));
        else out.print((b-a)+(d-c));

        f.close();
        out.close();
    }
}
