import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RangeReconstruction {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(f.readLine());

        ArrayList<ArrayList<Integer>> ranges = new ArrayList<ArrayList<Integer>>();
        StringTokenizer tokenizer;
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> range = new ArrayList<>();
            tokenizer = new StringTokenizer(f.readLine());
            while(tokenizer.hasMoreTokens()) {
                range.add(Integer.parseInt(tokenizer.nextToken()));
            }
            ranges.add(range);
        }

        final int startingNum = 1;

        long[] ans = new long[N];
        ans[0] = startingNum;

        long runningMin = startingNum;
        long runningMax = startingNum;

        int failsafe = 0;
        boolean fail = false;
        for(int i = 1; i < N; i++) {
            int diff = ranges.get(i-1).get(1);
            if(diff == 0) {
                ans[i] = ans[i-1];
            } else {
                long a = ans[i-1] + diff;
                long b = ans[i-1] - diff;

                if(i == 1) {
                    ans[i] = a; // add by default to save my three brain cells
                    runningMax = Math.max(a, runningMax);
                } else {
                    int change = ranges.get(0).get(i)-ranges.get(0).get(i-1);

                    boolean aOut = false;
                    boolean bOut = false;

                    if(a > runningMax || a < runningMin) {
                        // a is out of bounds
                        aOut = true;
                    }

                    if(b > runningMax || b < runningMin) {
                        // b is out of bounds
                        bOut = true;
                    }

                    if(aOut && bOut || !aOut && !bOut) {
                        // use differences instead
                        if(a - runningMax == change && runningMin - b == change) {
                            if(!fail) {
                                ans[i] = a;
                                runningMax = Math.max(runningMax, a);
                                failsafe = i;
                            } else {
                                fail = false;
                                ans[i] = b;
                                runningMin = Math.min(runningMin, b);
                                failsafe = 0;
                            }
                        } else if(a - runningMax == change) {
                            ans[i] = a;
                            runningMax = Math.max(runningMax, a);
                        } else if (runningMin - b == change) {
                            ans[i] = b;
                            runningMin = Math.min(runningMin, b);
                        } else {
                            fail = true;
                            for(int j = failsafe; j <= i; j++) {
                                ans[j] = 0;
                                i = failsafe;
                            }
                        }
                    } else {
                        if(change > 0) {
                            // outside the set
                            if(aOut) {
                                ans[i] = a;
                                runningMax = Math.max(runningMax, a);
                            } else if (bOut) {
                                ans[i] = b;
                                runningMin = Math.min(runningMin, b);
                            }
                        } else {
                            // inside the set
                            if(aOut) {
                                ans[i] = b;
                                runningMin = Math.min(runningMin, b);
                            } else if (bOut) {
                                ans[i] = a;
                                runningMax = Math.max(runningMax, a);
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(ranges);
        for(int i = 0; i < ans.length; i++) {
            if(i != ans.length - 1) {
                System.out.print(ans[i] + " ");
            } else {
                System.out.println(ans[i]);
            }
        }
    }
}
