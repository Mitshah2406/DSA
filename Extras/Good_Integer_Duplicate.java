import java.io.*;
import java.util.*;
/*
Given N array Integers, Calculate number of good integers. An element is said to be good integers, if {No. of element < element == element itself}

Note: Array elements can be duplicate.

Time - O(nLogn)
Space - O(N)
just keep hm to keep track of dups and remove them when counting
*/
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            int lessThan = i - hm.getOrDefault(arr[i],0);
            if(lessThan==arr[i]){
                ans++;
            }
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        
        System.out.println(ans);
    }
}
