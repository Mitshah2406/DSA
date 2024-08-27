class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        int ans = 1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}