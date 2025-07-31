import java.io.*;
import java.util.*;

public class Solution {
    /*
    We are ORing the number with left shifted Kth number because 1 & anything or always yeild 1, 
    xor is not used because if the kth bit to be sit is already 1, then answer could be wrong
    
    TC = O(1), Sc = O(1)
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.println((n|(1<<k)));
    }
}
