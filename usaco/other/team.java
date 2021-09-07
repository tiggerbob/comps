import java.io.*;
import java.util.*;

// CF problem ----- Team

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./src/out.txt")));

        int numproblems = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i = 0; i < numproblems; i++) {
            String s = br.readLine();
            if(s.chars().filter(num -> num == '1').count() > 1) ans++;
        }
        out.print(ans);
        out.close();
    }
}
