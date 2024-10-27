class Solution {
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    for (char x = '1'; x <= '9'; x++) {
                        if (valid(board, i, j, x)) {
                            board[i][j] = x;
                            boolean ans = solve(board);
                            if (ans==true) {return true;}
                            else {board[i][j] = '.';}
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean valid(char[][] board, int row, int col, char x) {
        // find in row & col

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == x || board[row][i] == x) {
                return false;
            }
        }

        // find minibox(subbox) top left coords
        int topLeftRowCorner = 3 * (row / 3);
        int topLeftColCorner = 3 * (col / 3);

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[topLeftRowCorner + i][topLeftColCorner + j] == x) {
                    return false;
                }
            }
        }

        // all cases pass
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}