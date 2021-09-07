import java.io.*;
import java.util.*;

// CF problem ----- Soldier and Number Game

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./src/out.txt")));
        StringBuilder str = new StringBuilder();

        int numrounds = Integer.parseInt(br.readLine());
        for(int i = 0; i < numrounds; i++) {
            int ans = 0;
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()), b = Integer.parseInt(tokenizer.nextToken());
            for(int j = a; j > b; --j) {
                int n = j;
                while(n%2 == 0) {
                    n /= 2;
                    ans++;
                }
                for(int m = 3; m <= n; m++) {
                    if(n == 1) break;
                    if(n%m == 0) {
                        n /= m;
                        ans++;
                    }
                }
            }
            str.append(ans).append("\n");
        }
        out.print(str.toString());
        out.close();

    }
}
