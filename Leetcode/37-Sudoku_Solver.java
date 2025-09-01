class Solution {

    /*
        Intuition:

        - This is a classic backtracking problem (Sudoku Solver).
        - We go cell by cell.
          If the cell is already filled, we move forward.
          If it's empty ('.'), we try putting digits 1 to 9.
        - For each digit, we check:
            1. Not already present in the same row
            2. Not already present in the same column
            3. Not already present in the 3x3 subgrid
        - If a number is valid, we place it and move ahead recursively.
        - If at some point we get stuck (no valid number fits), we backtrack 
          (reset the cell to '.' and try next possibility).
        - Finally, when the whole board has no empty cells, solution is ready.

        Time Complexity (rough):
            - In the worst case, for each empty cell we may try up to 9 numbers.
            - So, upper bound is O(9^(81)) -> very large.
            - But due to pruning (validity checks), it works fast in practice.

        Space Complexity:
            - O(1) extra space (we modify board in place).
            - Only recursion stack depth (up to 81 in worst case).
    */

    private boolean solve(char board[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Empty cell found
                if (board[i][j] == '.') {
                    // Try numbers 1 to 9
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidPlacement(board, i, j, ch)) {
                            board[i][j] = ch; // place number
                            if (solve(board)) {
                                return true; // solved further
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    // If no number fits, return false (backtrack)
                    return false;
                }
            }
        }
        return true; // all cells filled
    }

    /*
        isValidPlacement(board, row, col, ch):

        - This function checks if we can safely put digit 'ch' at (row, col).

        - We need to make sure:
            1. Row check -> 'ch' should not already exist in that row.
            2. Column check -> 'ch' should not already exist in that column.
            3. Subgrid check -> 'ch' should not already exist in the 3x3 box.

        Subgrid indexing explained with example:

            Formula: 
                Row index = 3 * (row / 3) + i / 3
                Col index = 3 * (col / 3) + i % 3

            Example: suppose row = 4, col = 5
            -> This cell is in the middle 3x3 box.

            Step 1: Find top-left of the 3x3 box
                row / 3 = 4 / 3 = 1
                col / 3 = 5 / 3 = 1
                So top-left = (3*1, 3*1) = (3, 3)

            Step 2: Now loop i = 0..8
                i=0 -> (3+0, 3+0) = (3,3)
                i=1 -> (3+0, 3+1) = (3,4)
                i=2 -> (3+0, 3+2) = (3,5)
                i=3 -> (3+1, 3+0) = (4,3)
                i=4 -> (3+1, 3+1) = (4,4)
                i=5 -> (3+1, 3+2) = (4,5)
                i=6 -> (3+2, 3+0) = (5,3)
                i=7 -> (3+2, 3+1) = (5,4)
                i=8 -> (3+2, 3+2) = (5,5)

            So this covers all 9 cells in the subgrid
            without needing a nested loop.
    */
    private boolean isValidPlacement(char board[][], int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Row check
            if (board[row][i] == ch)
                return false;
            // Column check
            if (board[i][col] == ch)
                return false;
            // Subgrid check using formula
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
