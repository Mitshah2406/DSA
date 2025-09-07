import java.io.*;
import java.util.*;
// Given N length Array, at every step remove an array element. Cost to remove element = sum of array elements present. Find min cost to remove all the elements.

// Note: Add to cost first and then remove.

// Time - O(nLogn) + O(n) = O(nLogn)
// Space - O(1)
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        // sort the arr, and remove elements from last, so sum is minimized.
        Arrays.sort(arr);
        int sum = 0, ans = 0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            ans+=sum;
        }
        System.out.println(ans);
    }
}
