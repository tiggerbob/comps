import java.io.*;
import java.util.*;

public class word {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int wordnum = Integer.parseInt(tokenizer.nextToken());
        int chars = Integer.parseInt(tokenizer.nextToken());

        ArrayList<String> words = new ArrayList<String>();
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < wordnum; i++) {
            words.add(tokenizer.nextToken());
        }

        out.print(words.get(0));
        int currentLine = words.get(0).length();

        for(int i = 1; i < wordnum; i++) {
            if((words.get(i).length() + currentLine) <= chars) {
                out.print(" ");
                currentLine += words.get(i).length();
                out.print(words.get(i));
            } else {
                out.println("");
                out.print(words.get(i));
                currentLine = words.get(i).length();
            }
        }

        out.close();
        br.close();

    }
}
