import java.io.*;
import java.util.*;

public class Solution {
    private static int gcd(int a, int b){
        if(a==0) return b;
        if(a>b) return gcd(a%b, b);
        else return gcd(b%a,a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        
        /* 
        BRUTE - O(n^2*log phi(min(arr)))
        remove any one element to maximize gcd
        */
        // int max = 0;
        // for(int i=0;i<n;i++){
        //     int g = 0;
        //     for(int j=0;j<n;j++){
        //         if(i==j) continue;
        //         g = gcd(g,arr[j]);
        //     }
        //     max = Math.max(g,max);
        // }
        // System.out.println(max);
        
        /*
        OPTIMAL - O(n log min(arr)) + O(n log min(arr)) + O(n) with O(2n) space

        do prefix and suffix gcd
        then iterate and do gcd for p[i] and s[i+2], skipping i+1, if i+2, is not there consider 0
        */
        
        int p[] = new int[n];
        int s[] = new int[n];
        p[0] = arr[0];
        for(int i=1;i<n;i++){
            p[i] = gcd(p[i-1], arr[i]);
        }
        s[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            s[i] = gcd(s[i+1], arr[i]);
        }
        int max = 0;
        for(int i=0;i<n-1;i++){
            int first = p[i];
            if(i+2 >= n){
                 max = Math.max(max, p[i]);
            }else{
                max = Math.max(max, gcd(p[i], s[i+2]));
            }
        }
        System.out.println(max);
    }
}
