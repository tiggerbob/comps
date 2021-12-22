import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(f.readLine());
        int[] p = new int[N];
        int[] t = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[N];
        for(int i = 0; i < N; i++) {
            diff[i] = p[i]-t[i];
        }

        pw.println(countStuff(diff));
        pw.close();
    }

    public static int countStuff (int[] diff) {
        boolean isPos = false;
        boolean init = false;
        int edgeL = -1;
        int edgeR = -1;
        for(int i = 0; i < diff.length; i++) {
            if(!init) {
                if(diff[i] != 0) {
                    init = true;
                    edgeL = i;
                    if (diff[i] > 0) {
                        isPos = true;
                    }
                }
            }

            // if negative, initialized, and end of group
            if(!isPos && init && (diff[i] >= 0 || i == diff.length-1)) {
                // end of group
                if(i == diff.length-1 && diff[i] < 0) {
                    edgeR = i+1;
                } else {
                    edgeR = i;
                }
                init = false;
                int[] newArr = Arrays.copyOfRange(diff, edgeL, edgeR);
                Arrays.sort(newArr);
                int cut = newArr[newArr.length-1];
                for(int j = edgeL; j < edgeR; j++) {
                    diff[j] = diff[j] - cut;
                }
                count += Math.abs(cut);
                if(diff[i] > 0) {
                    i--;
                }
            } else if(isPos && init && (diff[i] <= 0 || i == diff.length-1)) {
                if(i == diff.length-1 && diff[i] > 0) {
                    edgeR = i+1;
                } else {
                    edgeR = i;
                }
                init = false;
                isPos = false;
                int[] newArr = Arrays.copyOfRange(diff, edgeL, edgeR);
                Arrays.sort(newArr);
                int cut = newArr[0];
                for(int j = edgeL; j < edgeR; j++) {
                    diff[j] = diff[j] - cut;
                }
                count += cut;
                if(diff[i] < 0) {
                    i--;
                }
            }
        }

        boolean cont = false;
        for (int j : diff) {
            if (j != 0) {
                cont = true;
                break;
            }
        }
        if(cont) {
            return countStuff(diff);
        } else {
            return count;
        }
    }

}
