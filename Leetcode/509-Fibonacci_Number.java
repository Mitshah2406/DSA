class Solution {
    // public int fib(int n) {
    //     int n0 = 0;
    //     int n1 = 1;
    //     if(n==0||n==1){
    //         return n;
    //     }
    //     int n2=n0+n1;
    //     for(int i=2;i<=n;i++){
    //         n2 = n0+n1;
    //         n0 = n1;
    //         n1=n2;
    //     }

    //     return n2;
    // }
    // TC - O(n), coz 2 recursive calls * tc of one fn is O(1) = O(2n) ~ O(n);  SC - O(n)
    public int fibonacci(int n, int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int x = fib(n-1); // count fib of n-1
        int y = fib(n-2); // count fib of n-2

        return dp[n] = x+y; // add & return
    }

    public int fib(int n){
        int dp[] = new int[n+1]; // dp size of n+1 coz of 0 indexing
        Arrays.fill(dp,-1); 

        return fibonacci(n, dp);
    }
}