class Solution {
    static int MOD = 1000000007;

    private void pSum(int arr[], int n, int ans[]) {
        ans[0] = arr[0] % MOD;

        for (int i = 1; i < n; i++) {
            ans[i] = (ans[i - 1] + arr[i]) % MOD;
        }
    }

    public int rangeSum(int[] arr, int n, int left, int right) {
        int pSum[] = new int[n];
        int sums[] = new int[(n * (n + 1)) / 2];
        pSum(arr, n, pSum);
        int i = 0;

        // adding all subarrays sums;
        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                if (s == 0) {
                    sums[i] = pSum[e];
                } else {
                    sums[i] = pSum[e] - pSum[s - 1];
                }
                i++;
            }
        }

        // sort sums arr

        Arrays.sort(sums);

        int l = left - 1;
        int r = right - 1;

        int finalAns = 0;

        for (int j = l; j <= r; j++) {
            finalAns = (finalAns + sums[j]) % MOD;
        }

        return finalAns;
    }
}