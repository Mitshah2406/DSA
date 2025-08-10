import java.io.*;
import java.util.*;

public class Solution {
    private static boolean checkBit(int n, int k){
        if((n&(1<<k))==0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for(int k=0;k<=31;k++){
            int bitCount = 0;
            for(int i=0;i<n;i++){
                if(checkBit(arr[i],k)){
                    bitCount++;
                }
            }
            
            if(bitCount%3!=0){
                ans = ans | (1<<k);
            }
        }
        
        System.out.println(ans);
    }
}
