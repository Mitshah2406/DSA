class Solution {
    public void ratInMaze(int mat[][], int n, int i, int j, StringBuilder path, ArrayList<String> ans){
        // Base case: out of bounds or blocked cell or already visited cell
        if (i < 0 || j < 0 || i >= n || j >= n || mat[i][j] == 0 || mat[i][j] == 2) {
            return;
        }
        
        // Reached the destination
        if (i == n - 1 && j == n - 1) {
            ans.add(path.toString());
            return;
        }
        
        // Mark as visited
        mat[i][j] = 2;

        // Move Down
        if (i + 1 < n && mat[i + 1][j] == 1) {
            path.append("D");
            ratInMaze(mat, n, i + 1, j, path, ans);
            path.setLength(path.length() - 1);
        }

        // Move Right
        if (j + 1 < n && mat[i][j + 1] == 1) {
            path.append("R");
            ratInMaze(mat, n, i, j + 1, path, ans);
            path.setLength(path.length() - 1);
        }

        // Move Up
        if (i - 1 >= 0 && mat[i - 1][j] == 1) {
            path.append("U");
            ratInMaze(mat, n, i - 1, j, path, ans);
            path.setLength(path.length() - 1);
        }

        // Move Left
        if (j - 1 >= 0 && mat[i][j - 1] == 1) {
            path.append("L");
            ratInMaze(mat, n, i, j - 1, path, ans);
            path.setLength(path.length() - 1);
        }

        // Unmark visited
        mat[i][j] = 1;
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        
        // Check if the start or destination is blocked
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return ans;
        }

        StringBuilder path = new StringBuilder();
        ratInMaze(mat, n, 0, 0, path, ans);
        return ans;
    }
}