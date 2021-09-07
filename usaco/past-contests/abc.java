import java.io.*;
import java.util.*;

public class abc {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<Long> nums = new ArrayList<Long>();
        for(int i = 0; i < 7; i++) {
            nums.add(in.nextLong());
        }

        Collections.sort(nums);

        System.out.print(nums.get(0) + " " + nums.get(1) + " " + (nums.get(6)-(nums.get(0)+nums.get(1))));
    }
}
