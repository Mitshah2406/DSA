import java.io.*;
import java.util.*;

public class Solution {
    /*
    Intuition = MSB<->LSB
    
    0 = 000         4 = 100
    1 = 001         5 = 101
    2 = 010         6 = 110
    3 = 011         7 = 111
    
    Here, if we see odd number have 0th bit (LSB) set

    TC = O(1)
    SC = O(1)
    */
    public static boolean checkBit(int n, int k){
        if((n&(1<<k))==0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(checkBit(n,0) ? "odd" : "even");
        
    }
}
