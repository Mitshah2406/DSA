/*
    Intuition- attach 0 and n to arr, then sort , in this way we get access to lower and upper bound of stick
    then iterate for f(1,ogCuts.length)
    current cut cost will be arr[j+1]-arr[i-1] 

    0 [2 3 4] 12
 */
class Solution {
    // public int find(int i, int j, int[] cuts, int dp[][]) {
    //     if (i > j) {
    //         return 0;
    //     }
    //     if(dp[i][j]!=0){
    //         return dp[i][j];
    //     }
    //     int min = (int) 1e9;
    //     for (int k = i; k <= j; k++) {
    //         int len = cuts[j + 1] - cuts[i - 1];
    //         int cut = len + find(i, k - 1, cuts) + find(k + 1, j, cuts);
    //         min = Math.min(min, cut);
    //     }
    //     return dp[i][j] = min;
    // }

    public int minCost(int n, int[] cuts) {
        // Arrays.sort(cuts);
        // int cutLength = cuts.length;
        // int arr[] = new int[cutLength + 2];
        // arr[0] = 0;
        // arr[arr.length - 1] = n;
        // // [0,1,3,4,5,7]
        // for (int i = 1; i < arr.length - 1; i++) {
        //     arr[i] = cuts[i - 1];
        // }
        // int dp[][] = new int[cutLength + 2][cutLength + 2];
        // for(int d[]:dp){
        //     Arrays.fill(d,-1);
        // }
      
        // return find(1, cutLength, arr,dp);


        Arrays.sort(cuts);
        int cutLength = cuts.length;
        int arr[] = new int[cutLength + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        // [0,1,3,4,5,7]
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = cuts[i - 1];
        }
        int dp[][] = new int[cutLength + 2][cutLength + 2];
        
        for(int i=cutLength;i>=1;i--){
            for(int j=1;j<=cutLength;j++){
                if(i>j) continue;
                int min = (int) 1e9;
                for (int k = i; k <= j; k++) {
                    int len = arr[j + 1] - arr[i - 1];
                    int cut = len + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cut);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][cutLength];
    }
}