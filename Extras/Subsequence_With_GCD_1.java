import java.io.*;
import java.util.*;

public class Solution {
    private static boolean checkBit(int n, int k){
        return (n&(1<<k))!=0;
    }
    private static int gcd(int a, int b){
        if(a==0) return b;
        if(a>b) return gcd(a%b,b);
        else return gcd(b%a,a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        /*
        Brute Force
        Time: O(2^n * n * log base phi(min(arr)))
        Space: O(n)
        */
//         boolean flag = false;
//         int total = 1<<n;
    
//         for(int i=1;i<total;i++){
//             int g = 0;
//             for(int b=0;b<n;b++){
//                 if(checkBit(i,b)){
//                     g = gcd(g,arr[b]);
//                 }
//             }
//             if(g==1){
//                 flag = true;
//                 break;
//             }
//         }
//         if(flag) System.out.println(true);
//         else System.out.println(false);
        
        
        
        /*
        Optimal
        Take gcd of entire array, if gcd comes out as 1, 
        there exist some subsequence which had gcd as 1, which forces entire array's gcd to be 1
        
        Time = O(n*log base phi (min(arr)))
        Space = O(n)
        */
        int g = 0;
        for(int i=0;i<n;i++){
            g = gcd(g, arr[i]);
        }
        System.out.println(g==1);
    }
}
