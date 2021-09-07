/*
ID: tiggerb1
LANG: JAVA
TASK: friday
*/

import java.io.*;

class friday {
    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new FileWriter("friday.out"));

        int years = Integer.parseInt(f.readLine());
        int[] thirteen = new int[7]; //S S M T... etc.
        int currentday = 2; // M

        for(int i = 0; i < years*12; i++) {
            int month = i%12;
            currentday += 12;
            thirteen[currentday%7] += 1;
            if(month == 3 || month == 5 || month == 8 || month == 10 || month == 1) {
                // 30 days + feb
                if(month == 1) {
                    // feb
                    if(((i-1)/12)%4 == 0 && ((i-1)/12)%100 != 0) {
                        // leap year- 29 days
                        currentday += 17;
                    } else {
                        if((((i-1)/12)-100)%400 == 0) {
                            // 29 (400 yr)
                            currentday += 17;
                        } else {
                            // 28 days
                            currentday += 16;
                        }
                    }
                } else {
                    // not feb
                    currentday += 18;
                }
            } else {
                // 31 days
                currentday += 19;
            }
        }

        out.println(thirteen[0] + " " + thirteen[1] + " " + thirteen[2] + " " + thirteen[3] + " " + thirteen[4] + " " + thirteen[5] + " " + thirteen[6]);
        
        f.close();
        out.close();
    }
}
