/*
* Grid Illumination Problem Solution
* 
* Approach: Use hashmaps to track lamp counts by row, column, and diagonals(both).
* For each query, check if position is illuminated by any lamp in same row/col/diagonal,
* then turn off all lamps in 3x3 area around query point.
* 
* Key insight: A lamp at (i,j) illuminates entire row i, column j, 
* main diagonal (i-j), and anti-diagonal (i+j).
* 
* TC: O(L + Q) where L = lamps, Q = queries
* SC: O(L) for storing lamp positions and counts
*/
class Solution {
    private int convertTo1DCoord(int i, int j, int m) {
        // 2D coordinate to 1D Cell Number (Flattening 2D Matrix to 1D Array)
        // Formula - (rowNumber*totalCols)+colNumber;
        return (i * m) + j;
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int lampsLen = lamps.length;
        int qLen = queries.length;

        // Initializing hm for storage of lamps

        HashMap<Integer, Integer> rowMap = new HashMap<>(); // Row Number -> Count of Lamps
        HashMap<Integer, Integer> columnMap = new HashMap<>(); // Column Number -> Count of Lamps
        HashMap<Integer, Integer> firstDiagonalMap = new HashMap<>(); // First Diagonal Number (i-j) -> Count of Lamps
        HashMap<Integer, Integer> secondDiagonalMap = new HashMap<>(); // Second Diagonal Number (i+j) -> Count of Lamps
        HashMap<Integer, Integer> cellMap = new HashMap<>(); // 1D Cell Number (i*totalCols+j) -> Count of Lamps

        // initializing array for returning ans of queries
        int ans[] = new int[qLen];
        /*
        9 box directions with origin (0,0)
                 0 1 2
            0    - - -
            1    - * -
            2    - - -
        */
        int dirs[][] = {
                { 0, 0 }, // stay in place
                { 1, 0 }, // move down
                { 0, 1 }, // move right
                { -1, 0 }, // move up
                { 0, -1 }, // move left
                { 1, 1 }, // move down-right (diagonal)
                { -1, -1 }, // move up-left (diagonal)
                { -1, 1 }, // move up-right (diagonal)
                { 1, -1 } // move down-left (diagonal)
        };

        // processing lamps into the above maps created
        for (int lamp[] : lamps) {
            int x = lamp[0];
            int y = lamp[1];

            rowMap.put(x, rowMap.getOrDefault(x, 0) + 1);
            columnMap.put(y, columnMap.getOrDefault(y, 0) + 1);
            firstDiagonalMap.put(x - y, firstDiagonalMap.getOrDefault(x - y, 0) + 1);
            secondDiagonalMap.put(x + y, secondDiagonalMap.getOrDefault(x + y, 0) + 1);
            cellMap.put(convertTo1DCoord(x, y, n), cellMap.getOrDefault(convertTo1DCoord(x, y, n), 0) + 1);
        }

        // Processing queries
        for (int q = 0; q < qLen; q++) {
            int x = queries[q][0];
            int y = queries[q][1];

            // checking if coordinate is illuminated
            if (rowMap.getOrDefault(x, 0) > 0 || columnMap.getOrDefault(y, 0) > 0
                    || firstDiagonalMap.getOrDefault(x - y, 0) > 0 || secondDiagonalMap.getOrDefault(x + y, 0) > 0) {
                ans[q] = 1; // set to 1 if bulb is illuminated
            }

            // turning off the lamp, and its adjacent 8 lamps 

            for (int d[] : dirs) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= n)
                    continue;
                int cell = convertTo1DCoord(x1, y1, n);

                if (cellMap.getOrDefault(cell, 0) > 0) {
                    int lampCount = cellMap.get(cell); // get Lamps at this coordinate
                    // remove them all
                    cellMap.remove(cell);
                    // now start decrementing the counts in the subsequent row,col,firstDiag, secondDiag maps
                    // Decrement counters by the actual number of lamps being removed
                    int newRowCount = rowMap.getOrDefault(x1, 0) - lampCount;
                    if (newRowCount == 0)
                        rowMap.remove(x1);
                    else
                        rowMap.put(x1, newRowCount);

                    int newColCount = columnMap.getOrDefault(y1, 0) - lampCount;
                    if (newColCount == 0)
                        columnMap.remove(y1);
                    else
                        columnMap.put(y1, newColCount);

                    int newFirstDiagCount = firstDiagonalMap.getOrDefault(x1 - y1, 0) - lampCount;
                    if (newFirstDiagCount == 0)
                        firstDiagonalMap.remove(x1 - y1);
                    else
                        firstDiagonalMap.put(x1 - y1, newFirstDiagCount);

                    int newSecondDiagCount = secondDiagonalMap.getOrDefault(x1 + y1, 0) - lampCount;
                    if (newSecondDiagCount == 0)
                        secondDiagonalMap.remove(x1 + y1);
                    else
                        secondDiagonalMap.put(x1 + y1, newSecondDiagCount);
                }

            }
        }
        return ans;
    }
}