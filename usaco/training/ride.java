/*
ID: tiggerb1
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

class ride {

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        
        char[] grouparr = f.readLine().trim().toCharArray();
        int group = 1; 
        for (char ch :
                grouparr) {
            group *= (int)ch - (int)'A' + 1;
        }

        char[] ufoarr = f.readLine().trim().toCharArray();
        int ufo = 1;
        for (char ch :
                ufoarr) {
            ufo *= (int)ch - (int)'A' + 1;
        }

        if(group % 47 == ufo % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}
