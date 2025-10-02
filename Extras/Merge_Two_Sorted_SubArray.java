import java.io.*;
import java.util.*;

public class Solution {
    /*
    Time = O(n)
    Space = O(n)
    */
    private static void merge(int arr[], int n, int st, int mid, int end){
        int res[] = new int[end-st+1];
        int i = st, j = mid+1, k = 0;
        
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                res[k++] = arr[i++];
            }else{
                res[k++] = arr[j++];
            }
        }
        while(i<=mid){
            res[k++] = arr[i++];
        }
        while(j<=end){
            res[k++] = arr[j++];
        }
        for(int e=0;e<=(end-st);e++){
            arr[e+st] = res[e];
        }
        for(int ele : arr) System.out.print(ele + " ");
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int st = sc.nextInt(), mid = sc.nextInt(), end = sc.nextInt();
        merge(arr,n, st,mid,end);
    }
}
