/*
    N-Queens Problem Intuition:
    
    We want to place N queens on an N×N chessboard such that:
    - No two queens attack each other
    - i.e., no two queens share the same column, 
      same main diagonal (row-col), or same anti-diagonal (row+col).

    Approach:
    - Use backtracking, row by row.
    - At each row "i", try placing a queen in every column "q".
    - Use:
        colMap[q]         -> marks if column q already has a queen
        firstDiagMap(i-q) -> marks if that main diagonal already has a queen
        secondDiagMap(i+q)-> marks if that anti diagonal already has a queen
    - If safe, place the queen, recurse for the next row.
    - If we reach row == n, we've found a valid arrangement.
    - Backtrack after trying each position.

    Output:
    - For each valid configuration, build a list of strings representing the board
      with 'Q' for queen and '.' for empty cells.

    Time Complexity:
    - In worst case it's O(N!), since for each row we try N columns 
      and prune invalid ones with sets. It's exponential but heavily pruned.

    Space Complexity:
    - O(N) for recursion stack
    - O(N) for colMap, firstDiagMap, secondDiagMap
    - O(N^2) overall to store all possible solutions.
*/
class Solution {
    private void solve(int i, int n, boolean colMap[], HashSet<Integer> firstDiagMap, HashSet<Integer> secondDiagMap,
            int validSequence[], List<List<String>> queens) {
        if (i == n) {
            List<String> temp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[validSequence[k]] = 'Q';
                temp.add(new String(row));
            }
            queens.add(temp);
            return;
        }

        for (int q = 0; q < n; q++) {
            if (!colMap[q] && !firstDiagMap.contains(i - q) && !secondDiagMap.contains(i + q)) {
                colMap[q] = true;
                validSequence[i] = q;
                firstDiagMap.add(i - q);
                secondDiagMap.add(i + q);

                solve(i + 1, n, colMap, firstDiagMap, secondDiagMap, validSequence, queens);

                validSequence[i] = -1;
                colMap[q] = false;
                firstDiagMap.remove(i - q);
                secondDiagMap.remove(i + q);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> queens = new ArrayList<>();
        HashSet<Integer> firstDiagMap = new HashSet<>();
        HashSet<Integer> secondDiagMap = new HashSet<>();
        boolean colMap[] = new boolean[n];
        int validSequence[] = new int[n];
        Arrays.fill(validSequence, -1);
        solve(0, n, colMap, firstDiagMap, secondDiagMap, validSequence, queens);
        return queens;
    }
}
