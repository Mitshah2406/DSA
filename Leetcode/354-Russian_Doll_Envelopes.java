class Solution {
    public int find(int i, int prev, int n, int envelopes[][], int dp[][]) {
        if (i == n) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int take = 0;
        if (prev == -1 || envelopes[prev][1] < envelopes[i][1]) {
            take = 1 + find(i + 1, i, n, envelopes, dp);
        }
        int skip = find(i + 1, prev, n, envelopes, dp);
        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        // int dp[][] = new int[n][n + 1];
        // for (int d[] : dp)
        //     Arrays.fill(d, -1);
        // return find(0, -1,n, envelopes, dp);
        // int dp[] = new int[n];
        // dp[0] = 1;
        // int max = 1;
        // for(int i=1;i<n;i++){
        //     dp[i]=1;
        //     for(int j=0;j<i;j++){
        //         if(envelopes[j][1]<envelopes[i][1]){
        //             dp[i] = Math.max(dp[i], 1+ dp[j]);
        //         }
        //     }
        //     max = Math.max(max, dp[i]);
        // }

        // return max;

        int dp[] = new int[n];

        dp[0] = envelopes[0][1];
        int st = 0;
        int end = 1;
        for (int i = 1; i < n; i++) {
            if (envelopes[i][1] > dp[end - 1]) {
                dp[end++] = envelopes[i][1];
                continue;
            }

            // perform bs for insertion
            int low = st;
            int high = end - 1;
            int ans = end;
            while (low < high) {
                int mid = low + (high - low) / 2;

                if (dp[mid] < envelopes[i][1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            dp[high] = envelopes[i][1];
            if (high == end) {
                end++;
            }
        }
        return end;
    }
}

// [[5,4],[6,4],[6,7],[2,3]]
// [[2,3],[5,4],[6,7],[6,4]]