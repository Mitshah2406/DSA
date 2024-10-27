class Solution {
    public boolean solve(char[][] board) {
        // traverse the board row wise
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // check for empty cell
                if (board[i][j] == '.') {
                    // try placing 1-9
                    for (char x = '1'; x <= '9'; x++) {
                        // check if placement is valid acc to current board state
                        if (valid(board, i, j, x)) {
                            // place
                            board[i][j] = x;
                            //solve further
                            boolean ans = solve(board);
                            // if board fully solved return true, else bacltrack
                            if (ans==true) {return true;}
                            else {board[i][j] = '.';}
                        }
                    }
                    // if no number satisfies for this cell means earlier cell has some placment wrong
                    return false;
                }
            }
        }
        // return true if solved completely
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