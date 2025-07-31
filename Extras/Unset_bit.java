import java.io.*;
import java.util.*;

public class Solution {
    /*
    Intuition:
    To unset (clear) the k-th bit of a number, we need to ensure it becomes 0.  
    We cannot directly unset it in one step because:
    - XOR toggles bits (1 becomes 0, 0 becomes 1).
    - AND can only clear bits if used with a proper mask.

    Approach:
    1. First, isolate the k-th bit using (n & (1 << k)).
    2. XOR this isolated bit with n, which toggles it to 0 if it was set (1).  
    If the bit was already 0, XOR has no effect.

    Thus, using (n ^ (n & (1 << k))) unsets the k-th bit.
    
    TC = O(1), SC = O(1)
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println(n^(n&(1<<k)));
    }
}
