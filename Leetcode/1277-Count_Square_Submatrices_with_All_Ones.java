class Solution {
    public int solve(int mat[][],  int i, int j, int dp[][]) {
        if(i<0||j<0||mat[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int top = solve(mat,i-1,j,dp);
        int left = solve(mat,i,j-1,dp);
        int topLeft = solve(mat,i-1,j-1,dp);

        return dp[i][j] = 1+ Math.min(Math.min(top, left),topLeft);
    }

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
            for (int j = 0; j < m; j++) {
                ans+= solve(matrix,  i, j, dp);
            }
        }

        return ans;
    }
}

//Brute force ===
// class Solution {
//     public boolean check(int mat[][], int stR, int stC, int endR, int endC){
//         for(int i=stR;i<=endR;i++){
//             for(int j=stC;j<=endC;j++){
//                 if(mat[i][j]==0){
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
//     public int countSquares(int[][] matrix) {
//         int ans = 0;
//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 ans+=matrix[i][j];
//                 if(matrix[i][j]==0){
//                     continue;
//                 }
//                 int r = i+1;
//                 int c = j+1;
//                 while(r<n && c<m){
//                     if(matrix[r][c]==0) break;
//                     if(check(matrix,i,j,r,c)){

//                         ans++;
//                     }
//                     r++;
//                     c++;
//                 }
//             }
//         }
//         return ans;

//     }
// }