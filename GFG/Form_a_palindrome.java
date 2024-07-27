class Solution{
    // fn calls * TC(one fn)
    // fn calls * O(1)
    // filling a O(n^2) matrix in worst case
    private static int lcs(String str1, String str2, int i, int j, int dp[][]){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            dp[i][j] = 1 + lcs(str1, str2, i-1,j-1, dp);
            return dp[i][j];
        }
        
        dp[i][j] = 0 + Math.max(lcs(str1, str2, i-1,j, dp), lcs(str1, str2, i,j-1, dp));
        return dp[i][j];
    }
    static int countMin(String str)
    {
        int n = str.length();
        StringBuilder s2 = new StringBuilder(str);
        
        int dp[][] = new int[n][n];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        int ans = lcs(str, s2.reverse().toString(), n-1,n-1, dp);
        return n - ans;
        
    }
}
