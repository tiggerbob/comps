import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String[] nums = br.readLine().split(" ");
            int n1 = Integer.parseInt(nums[0]);
            int n2 = Integer.parseInt(nums[1]);
            ArrayList<String> items = new ArrayList<>();
            for(int j = 0; j < n1; j++) {
             items.add(br.readLine().trim());
            }
            ArrayList<String> recorded = new ArrayList<>();
            for(int j = 0; j < n2; j++) {
                recorded.add(br.readLine().trim());
            }

            List<String> output = new ArrayList<>();
            for(int j = 0; j < n2; j++) {
                if(!items.contains(recorded.get(j))) {
                    output.add(items.get(j));
                }
            }
            for (String s :
                    output) {
                System.out.println(s);
            }
        }
    }
}