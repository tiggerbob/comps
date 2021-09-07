import java.io.*;
import java.util.*;

// CF problem ----- Soldier and Bananas

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/in.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./src/out.txt")));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int firstCost = Integer.parseInt(tokenizer.nextToken());
        int money = Integer.parseInt(tokenizer.nextToken());
        int numBananas = Integer.parseInt(tokenizer.nextToken());
        int ans = 0;

        for(int i = 1; i <= numBananas; i++) {
            ans += i;
        }

        if(ans * firstCost > money) out.print((ans*firstCost)-money);
        else out.print("0");

        out.close();
    }
}
