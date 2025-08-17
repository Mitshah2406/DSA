import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /*
        Problem:
        Given an even integer N, create N/2 pairs using numbers {1, 2, ..., N}
        such that each pair is coprime. If not possible, return -1.

        Brute Force Approach:
        1. Loop through all possible pairs (i, j) where 1 <= i < j <= N.
        2. For each pair, calculate GCD(i, j).
        3. If GCD(i, j) == 1, keep the pair.
        4. Check if we can form exactly N/2 pairs.
        Time Complexity: O(N^2 * log(max(i,j))) // O(N^2) pairs, each GCD takes log(max(i,j))
        Space Complexity: O(1) // Only loop variables used

        Optimal Approach:
        1. Observation: Any two consecutive integers (i, i+1) are always coprime.
        2. Since N is even, we can pair them as (1,2), (3,4), ..., (N-1, N)
        3. This forms exactly N/2 pairs, all coprime.
        Time Complexity: O(N) // Single loop from 1 to N in steps of 2
        Space Complexity: O(1) // Only loop variables used
        */
        
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();

        if(N % 2 != 0){
            System.out.println(-1); // Not possible if N is odd
            return;
        }

        // Form N/2 pairs of consecutive numbers
        for(int i = 1; i <= N; i += 2){
            System.out.println(i + " " + (i+1));
        }
    }
}

