class Solution {
    int dp[][];
    private int solve(int l, int r, char[] s){
        if(l==r){
            // if there is only one character to be solved return 1 operation
            return 1;
        }
        if(l>r){
            // if l crosses r that string is traversed return 0
            return 0;
        }
        if(dp[l][r]!=0){
            return dp[l][r];
        }
        int i = l+1; // iterate from next character to check if same character exists as s[l]
        char lChar = s[l];
        while(i<=r && s[i]==lChar){
            i++;
        }

        if(i==r+1){
            // if all characters are same then return 1 operation
            return 1;
        }

        int basicApproach = 1 + solve(i,r,s); // count one operation of current wala and solve for next
        int lalach = Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if(lChar==s[j]){
                int t = solve(i,j-1,s) + solve(j,r,s);
                lalach = Math.min(lalach, t);
            }
        }

        return dp[l][r] = Math.min(basicApproach, lalach);
    }
    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n+1];
        return solve(0, n-1, s.toCharArray());
    }
}