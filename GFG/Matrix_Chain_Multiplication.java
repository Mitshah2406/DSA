class Solution {
    /*
    Partition DP
    
    Rules: 
    
    1. Start with entire block/array i.e. ; f(i,j)
    2. Try all parts -> Run a loop to try all partitions eg= f(i,k), f(k+1,j)
    3. Return the best possible two partitions
    4. identification of start and end (i,j) varies from problem to problem
    */
    static int find(int i, int j, int arr[], int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = (int) 1e9;
        for(int k=i;k<j;k++){
            // steps
            // (A) (BCD)
            // [1, 2, 3, 4, 3]
            //     ik       j
            // here a is 1x2, BCD = ((2x3)*(3*4)*(4*3)) = ((2x4)*(4*3)) = (2*3)
            // therefore, (1x2) and (2x3) = cost required would be 1*2*3; //2 common
            // hence i-1*k*j
            int steps = arr[i-1]*arr[k]*arr[j] + find(i,k,arr,dp) + find(k+1,j,arr,dp);
            min = Math.min(min,steps);
        }
        return dp[i][j] = min;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        // [1,2,3,4,3]
        //   A B C D       
        // A = arr[0] * arr[1];
        // B = arr[1] * arr[2];
        // .
        // .
        // .
        // Matrix = arr[i-1]*arr[i]
        // int n = arr.length;
        // int dp[][] = new int[n][n];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // return find(1,n-1,arr,dp);
        
        // Tabulation
        
        int n = arr.length;
        int dp[][] = new int[n][n];
        // 1. base cases - just for demonstration , can skip coz already default values are 0
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }
        
        // 2. changing variables
            // i => 1->n-1 => n-1->1
            // j => n-1->0 => i+1->n-1 // here i+1 coz logically j should be awlays ahead of i
            
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                // 3. copy recurrences
                int min = (int) 1e9;
                for(int k=i;k<j;k++){
                    // steps
                    // (A) (BCD)
                    // [1, 2, 3, 4, 3]
                    //     ik       j
                    // here a is 1x2, BCD = ((2x3)*(3*4)*(4*3)) = ((2x4)*(4*3)) = (2*3)
                    // therefore, (1x2) and (2x3) = cost required would be 1*2*3; //2 common
                    // hence i-1*k*j
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min,steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }
}
