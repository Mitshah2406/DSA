import java.util.*;
public class Solution {
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        dp[0] = 1;
        hash[0] = 0;
        int max = 1;
        int maxIdx= 0;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            hash[i] = i;
            int res = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(res<1+dp[j]){
                        res = 1+dp[j];
                        hash[i] = j;
                    }
                }
            }
            dp[i] = res;
            if(max<dp[i]){
                max = dp[i];
                maxIdx = i;
            }
        }

        // find max in dp and backtrack on hash table
        int it = maxIdx;
        while(it>=0 && it!=hash[it]){
            ans.add(arr[it]);
            int lastIdx = hash[it];
            it = lastIdx;
        }
        ans.add(arr[it]);
        Collections.reverse(ans);
        return ans;


        /*
        */
    }
}
