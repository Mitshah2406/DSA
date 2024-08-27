class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // USE LIS {Longest Increasing Subsequence concept }

        // sort any one parameter then apply LIS on the other using BINARY SEARCH ON ANS
        int n = envelopes.length;
        int dp[] = new int[n];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                int ans = a[0] - b[0];
                if(ans!=0){
                    return ans;
                }

                return ans = b[1]-a[1];
            }
        });

    
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = ans;
            int curr = envelopes[i][1];
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (dp[mid] < curr) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = curr;
            if (low == ans) {
                ans++;
            }

        }
        return ans;
    }
}