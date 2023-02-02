import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);

        int n = Integer.parseInt(f.nextLine());
        String s = f.nextLine();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long lhs = 0;
            if (i > 0 && s.charAt(i-1) != s.charAt(i)) {
                lhs++;
                for (int j = i-2; j >= 0 && s.charAt(j) == s.charAt(i-1); j--) lhs++;
            }
            long rhs = 0;
            if (i+1 < n && s.charAt(i+1) != s.charAt(i)) {
                rhs++;
                for (int j = i+2; j < n && s.charAt(j) == s.charAt(i+1); j++) rhs++;
            }
            ans += lhs * rhs + Math.max(lhs-1, (long) 0) + Math.max(rhs-1, (long) 0);
        }
        System.out.println(ans);
    }
}