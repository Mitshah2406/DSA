//User function Template for Java
class Solution 
{   
    private int dp[][][];
    
    private int memo(char[] a, char[] b, char[] c, int i, int j, int k){
        if(i<0||j<0||k<0){
            return 0;
        }
        
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        int ans = 0;
        if(a[i]==b[j] && b[j]==c[k]){
            ans = 1 + memo(a,b,c,i-1,j-1,k-1);
        }else{
            ans = Math.max(Math.max(memo(a,b,c,i-1,j,k), memo(a,b,c,i,j-1,k)), memo(a,b,c,i,j,k-1));
        }
        
        return dp[i][j][k] = ans;
    }
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        dp = new int[n1][n2][n3];
        for(int dp1[][]:dp){
            for(int dp2[]:dp1){
                Arrays.fill(dp2, -1);
            }
        }
        return memo(A.toCharArray(), B.toCharArray(), C.toCharArray(), n1-1, n2-1, n3-1);
    }
}
