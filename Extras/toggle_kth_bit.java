import java.io.*;
import java.util.*;

public class Solution {
  /*
    We are XORing the number with left shifted Kth number because xor flips bit which we want to do, 
    or is not used because if the kth bit to be set is already 1, then answer could be wrong
    
    TC = O(1), Sc = O(1)
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println((n^(1<<k)));
    }
}
