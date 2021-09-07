import java.io.*;
import java.util.*;

/*
ID: tiggerb1
LANG: JAVA
TASK: beads
*/

public class beads {
    static int beadsCounterFromStart(String beadsCut) {
        int ans = 0;
        boolean control = true;
        int currentBead = 0;
        char currentColor = 'b';
        for(int j = 0; j < beadsCut.length(); j++) {
            if(beadsCut.charAt(j) != 'w') {
                currentColor = beadsCut.charAt(j);
                break;
            }
        }
        while (control) {
            if(currentBead >= beadsCut.length()) break;
            if(beadsCut.charAt(currentBead) == 'w') {
                beadsCut = beadsCut.substring(0, currentBead) + currentColor + beadsCut.substring(currentBead+1);
                currentBead++;
            } else if(beadsCut.charAt(currentBead) == 'b') {
                if (currentColor != 'b') control = false;
                else {
                    currentBead++;
                }
            } else {
                if (currentColor != 'r') control = false;
                else {
                    currentBead++;
                }
            }
        }
        ans = currentBead;
        return ans;
    }

    static int beadsCounterFromEnd(String beadsCut) {
        int ans = 0;
        int tempans = 0;
        boolean control = true;
        int currentBead = beadsCut.length()-1;
        char currentColor = ' ';
        for(int j = beadsCut.length()-1; j >= 0; j--) {
            if(beadsCut.charAt(j) != 'w') {
                currentColor = beadsCut.charAt(j);
                break;
            }
        }
        while (control) {
            if (currentBead < 0){
                tempans = 0;
                break;
            }
            if(beadsCut.charAt(currentBead) == 'w') {
                beadsCut = beadsCut.substring(0, currentBead) + currentColor + beadsCut.substring(currentBead+1);
                currentBead--;
                tempans++;
            } else if(beadsCut.charAt(currentBead) == 'b') {
                if (currentColor != 'b') control = false;
                else {
                    currentBead--;
                    tempans++;
                }
            } else {
                if (currentColor != 'r') control = false;
                else {
                    currentBead--;
                    tempans++;
                }
            }
        }
        ans = tempans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int numBeads = Integer.parseInt(br.readLine());
        String beads = br.readLine();
        int ans = 0;
        for(int i = 0; i < numBeads; i++) {
            String beadsCut = beads.substring(i) + beads.substring(0, i);
            if(beadsCounterFromStart(beadsCut) + beadsCounterFromEnd(beadsCut) > ans) {
                if(beadsCounterFromStart(beadsCut) + beadsCounterFromEnd(beadsCut) > numBeads) ans = numBeads;
                else {
                    ans = beadsCounterFromStart(beadsCut) + beadsCounterFromEnd(beadsCut);
                }
            }
        }
        out.println(ans);
        out.close();
    }
}
