import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static class Cow implements Comparable<Cow> {
        public int index;
        public int destination;
        public int moos;

        public Cow(int index, int destination, int moos) {
            this.index = index;
            this.destination = destination;
            this.moos = moos;
        }
        
        public String toString() {
            return "(" + index + ", " + destination + ", " + moos + ")";
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(moos, o.moos);
        }
    }

    public static void main (String[] args) throws IOException {
//        System.out.println(10000);
//        for(int i = 1; i <= 10000; i++) {
//            System.out.println(i + " " + 1);
//        }
//        System.out.println(1 + " " + 1);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // use System.out.println() to print single line answer

        // first line: N
        int N = Integer.parseInt(f.readLine());

        // lines 2-N+1: input cows
        List<Cow> cows = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(f.readLine());
            Cow cow = new Cow(i, Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            cows.add(cow);
        }
//        System.out.println("Calculating...");

        // ------------------------------------------- //
        long total = 0;
        for(int i = 1; i <= N; i++) {
            total += cows.get(i-1).moos;
        }
//        System.out.println("Total finished");

        Set<Integer> solvedLocks = new HashSet<>();
        ArrayList<ArrayList<Integer>> locks = new ArrayList<>();
        for(int i = 1; i <= N && !solvedLocks.contains(cows.get(i-1).destination); i++) {
            // if the lock hasn't previously been solved
            // contains() arraylist O(n) O(mn + n)
            ArrayList<Integer> lock = new ArrayList<>();
            // index of starting point
            int startPoint = cows.get(i).destination;
            solvedLocks.add(startPoint);
            lock.add(startPoint);
            // destination of starting point
            // arraylist index starts from 0, cow index starts from 1
            int endPoint = cows.get(startPoint-1).destination;
            solvedLocks.add(endPoint);
            lock.add(endPoint);
            while(startPoint != endPoint) {
                endPoint = cows.get(endPoint-1).destination;
                if(startPoint != endPoint) {
                    solvedLocks.add(endPoint);
                    lock.add(endPoint);
                }
            }
//            System.out.println(solvedLocks);
            locks.add(lock);
        }

//        System.out.println("Lock counting finished");

        for (ArrayList<Integer> lock :
                locks) {
            ArrayList<Cow> cowArr = new ArrayList<Cow>();
            for (Integer i : lock) {
                cowArr.add(cows.get(i-1));
            }
            Collections.sort(cowArr);
//            System.out.println(cowArr);
            total -= cows.get(cowArr.get(0).index-1).moos;
        }

        // ------------------------------------------- //

        // result
        System.out.println(total);
    }
}