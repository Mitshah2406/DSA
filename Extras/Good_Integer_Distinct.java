import java.io.*;
import java.util.*;
/*
Given N array Integers, Calculate number of good integers. An element is said to be good integers, if {No. of element < element == element itself}

Note: Array elements are distinct.
time - O(nlogn)
space - O(1)
just sort and count no of elements == arr[i] , i.e i==arr[i]
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
        int ans= 0;
        for(int i=0;i<n;i++){
            if(i==arr[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
