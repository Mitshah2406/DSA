class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int prefixXor[] = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }

        int ans[] = new int[queries.length];
        int j = 0;
        for (int q[] : queries) {
            int u = q[0];
            int v = q[1];

            // if(u==v){
            // ans[j] = arr[u];
            // }else{
            if (u == 0) {
                ans[j] = prefixXor[v];
            } else {
                int res = prefixXor[v] ^ prefixXor[u - 1];
                ans[j] = res;
            }
            // }

            j++;
        }

        return ans;
    }
}