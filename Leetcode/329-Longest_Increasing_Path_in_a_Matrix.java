class Solution {
    /*
    * Approach Explanation:
    * 
    * We want to find the longest strictly increasing path in a 2D matrix,
    * where movement is allowed up, down, left, or right. We can think of a LIS Solution.
    But if we do by 2d grid with curr and prev as coordinates then it will be a 4d dp

    1st optimization = As we can start from anywhere we do not need to maintain prev, we can compare and go to the next cell, so a 2d dp

    2nd optimization = We can convert coordinates to flattened 1d array [(row*M)+col]
    * 
    * For each cell, we explore all possible increasing paths starting from it.
    * To avoid repeated calculations, we use memoization with a dp array that
    * caches the longest path length found for each cell.
    * 
    * We treat the matrix cells as nodes in a graph. From each cell, we recursively
    * visit neighboring cells with higher values, calculating the longest increasing
    * path starting from that neighbor. The answer for a cell is 1 plus the maximum
    * path length among its valid neighbors.
    * 
    * By checking every cell and taking the maximum among all, we find the
    * overall longest increasing path in the matrix.

    We dont use skip reccurences as we are finding a path which is always continuous



    Time = O(n*m) and not(O(n*m*{n*m})) because we are using a common dp array so for each cell find() is executed once only
    Space = O(n*m) + O(k) [k=Recursion Stack i.e m*n]
    */

    private int convertCoordinateToPoint(int r, int c, int m) {
        return (r * m) + c;
    }

    private int find(int curr, int n, int m, int matrix[][], int dirs[][],
            int dp[]) {

        if (dp[curr] != -1) {
            return dp[curr];
        }
        int res = 1;
        for (int d[] : dirs) {
            int currRow = curr / m;
            int currCol = curr % m;

            int nr = d[0] + currRow;
            int nc = d[1] + currCol;

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }
            if (matrix[currRow][currCol] < matrix[nr][nc]) {
                int send = convertCoordinateToPoint(nr, nc, m);
                int ans = 1 + find(send, n, m, matrix, dirs, dp);
                res = Math.max(ans, res);
            }
        }

        return dp[curr] = res;

    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[] = new int[n * m];
        Arrays.fill(dp, -1);
        int ans = Integer.MIN_VALUE;
        int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = convertCoordinateToPoint(i, j, m);
                int res = find(curr, n, m, matrix, dirs, dp);
                ans = Math.max(ans, res);
            }
        }

        return ans;
    }
}