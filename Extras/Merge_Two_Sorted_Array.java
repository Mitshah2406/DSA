import java.io.*;
import java.util.*;

public class Solution {
    /*
    Time - O(n+m) 
    Space - O(n+m)
    */
    private static void merge(int arr1[], int arr2[], int n, int m){
        int res[] = new int[n+m];
        int i = 0, j= 0, k =0;
        
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                res[k++] = arr1[i++];
            }else{
                res[k++] = arr2[j++];
            }
        }
        
        while(i<n){
            res[k++] = arr1[i++];
        }
         while(j<m){
            res[k++] = arr2[j++];
        }
        for(int y=0;y<res.length;y++) System.out.print(res[y] + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        
        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i] = sc.nextInt();
        }
        
        merge(arr1,arr2,n,m);
    }
}
