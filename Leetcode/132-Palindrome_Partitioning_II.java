class Solution {
    private static boolean isPalindrome(int i, int j, String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private static int fun(String s){
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 0;
        for(int cut=len-1;cut>=0;cut--){
            int minCuts = Integer.MAX_VALUE;
            for(int partition=cut;partition<len;partition++){
                if(isPalindrome(cut,partition,s)){
                    int cuts = 1 + dp[partition+1];
                    minCuts = Math.min(minCuts,cuts);
                }
            }
            dp[cut] = minCuts;
        }
        return dp[0]-1;
    }

    public int minCut(String s){
        return fun(s);
    }
}
// Tabulation Code 
// Time Complexity : ~ O(n*n), Quadratic Complexity
// Space Complexity : O(n)