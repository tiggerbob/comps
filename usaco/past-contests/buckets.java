import java.io.*;
import java.util.*;

public class buckets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));

        int BRow = 0, BCol = 0, LRow = 0, LCol = 0, RRow = 0, RCol = 0;

        for(int i = 0; i < 10; i++){
            String s = br.readLine();
            for(int j = 0; j < 10; j++) {
                if(s.charAt(j) == 'B') { BRow = i; BCol = j; }
                if(s.charAt(j) == 'L') { LRow = i; LCol = j; }
                if(s.charAt(j) == 'R') { RRow = i; RCol = j; }
            }
        }

        if(RRow == BRow && RRow == LRow || RCol == BCol && RCol == LCol) {
            if(Math.abs(RRow-BRow) > Math.abs(BRow-LRow) || Math.abs(RCol-BCol) > Math.abs(BCol-LCol) || Math.abs(RRow-LRow) > Math.abs(BRow-LRow) || Math.abs(RCol-LCol) > Math.abs(BCol-LCol)) out.print(Math.abs(LCol-BCol)+Math.abs(LRow-BRow)-1);
            else out.print(Math.abs(LCol-BCol)+Math.abs(LRow-BRow)+1);
        } else {
            out.print(Math.abs(LCol - BCol) + Math.abs(LRow - BRow) - 1);
        }
        out.close();
    }
}
