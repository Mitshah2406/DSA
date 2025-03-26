class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int rem = grid[0][0] % x;
        int arr[] = new int[n * m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[k++] = grid[i][j];
                if (grid[i][j] % x != rem) {
                    return -1;
                }
            }
        }

        Arrays.sort(arr); // sorting bcoz in increasing order it is always beneficial to make every ele same as median ele

        int mid = (int)Math.ceil((n * m) / 2);
        int op = 0;
            // System.out.println("mid"+arr[mid]);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==arr[mid]) continue;
            // System.out.println("adding"+arr[i]);
            
            int ans = Math.abs((arr[i] - arr[mid])) / x;
            // System.out.println("adding ans"+ans);
            op += ans;
        }

        return op;
    }
}