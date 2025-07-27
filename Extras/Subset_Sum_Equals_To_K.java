import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean find(int i, int sum, int k, int arr[], Boolean[][] dp){
        if(i==-1){
            return sum==k;
        }
        if(sum==k){
            return true;
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        boolean take = false;
        if(sum+arr[i]<=k){
            take = find(i-1,sum+arr[i], k, arr, dp);
        }
        boolean skip = find(i-1,sum,k,arr, dp);
        return dp[i][sum] = take || skip;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        Boolean dp[][] = new Boolean[n][k+1];
        return find(n-1,0,k, arr, dp);
    }
}
