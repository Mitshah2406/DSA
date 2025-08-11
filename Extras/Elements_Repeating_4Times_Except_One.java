import java.io.*;
import java.util.*;

public class Solution {
    public static int checkBit(int n, int k){
        if((n&(1<<k))==0){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        int res = 0;
        for(int j=0;j<32;j++){
            sum = 0;
            for(int i=0;i<n;i++){
                sum += checkBit(nums[i],j);
            }
            if(sum%4!=0){
                res+=1<<j;
            }
        }
        System.out.println(res);
    }
}
