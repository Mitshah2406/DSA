import java.util.* ;
import java.io.*; 

public class Solution {
    static int countDigit(long x) {
        int cnt = 0;

        // while(x!=0){
        //     // long d = x%10; // Not Needed as we only need to count the digits
        //     x = x/10;
        //     cnt++;
        // }

        // return cnt;

        /*
        Time Complexity = As we go on dividing x by 10, it O(log10(x))
        */

        // short form for counting digits
        // in java there isnt any log 10 or log 2 function
        // so use log exponent function with og number/ log e of base
        // log e(131) / log e(10) = 2.11727 +1  = 3 digits
        return (int)(Math.log(x) / Math.log(10)) + 1;
    }
}
