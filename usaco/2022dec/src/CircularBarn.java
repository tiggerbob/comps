import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CircularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(f.readLine());
            int[] rooms = new int[N];
            StringTokenizer tokenizer = new StringTokenizer(f.readLine());
            for(int n = 0; n < N; n++) {
                rooms[n] = Integer.parseInt(tokenizer.nextToken());
            }

//            System.out.println(Arrays.toString(rooms));
        }
    }
}
