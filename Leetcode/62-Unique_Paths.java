class Solution {
    /*
    TC = O(m*n)
    SC = O(m*n)
    */
    public int find(int row, int col, int i, int j, int dp[][]) {
        if (i == row - 1 && j == col - 1) {
            return 1;
        }
        if (i > row - 1 || j > col - 1) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int bottom = find(row, col, i+1, j, dp);
        int right = find(row, col, i, j+1, dp);

        return dp[i][j] = bottom + right;
    }

    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return find(m, n, 0, 0,dp);
    }
}