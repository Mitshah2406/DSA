class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(m*n!=len){
            return new int[][]{};
        }

        int ans[][] = new int[m][n];
        // simple math

        // row = i / cols
        // col = i % cols
        for(int i=0;i<len;i++){
            ans[i/n][i%n] = original[i];
        }

        return ans;
    }
}