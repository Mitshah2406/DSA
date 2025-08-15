class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        /**
        Brute Force (Can be done using O(n^2))
        Optimal - O(n), O(n)

        Intuition - Precalculate a prefix xor

        for each query, just use the prefix sum for a range logic, instead of minus for discarding the part, do xor, as same same elements evaluates to zero only !!
         */
        int n = arr.length;
        int prefix[] = new int[n];

        prefix[0] = arr[0];

        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]^arr[i];
        }
        int ans[] = new int[queries.length];
        int i=0;
        for(int q[]: queries){
            int st = q[0];
            int end = q[1];

            if(st==0){
                ans[i++] = prefix[end];
            }else{
                ans[i++] = prefix[end] ^ prefix[st-1];
            }
        }

        return ans;
    }
}
