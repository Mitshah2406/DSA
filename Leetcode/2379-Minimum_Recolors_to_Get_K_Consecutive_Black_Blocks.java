class Solution {
    /**
    Time - O(N^2), Space - O(1)
     */
    private int brute(String blocks, int n, int k) {
        int ans = n;

        for (int i = 0; i < n; i++) {
            int white = 0;
            for (int j = i; j < n; j++) {
                if (blocks.charAt(j) == 'W') {
                    white++;
                }
                if(j-i+1==k){
                    ans = Math.min(ans, white);
                    break;
                }
            }
        }
        return ans;
    }

    /**
    Time - O(N), Space - O(1)
    As k is mentioned, we use a fixed sized (k) sliding window technique
    Just count whites, and take min from windows
     */
    private int optimal(String blocks, int n, int k) {
        int white = 0, ans = n;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }
        ans = white;

        for (int right = k; right < n; right++) {
            // prune left - (at i-k)

            if (blocks.charAt(right - k) == 'W') {
                white--;
            }
            // add right
            if (blocks.charAt(right) == 'W') {
                white++;
            }

            ans = Math.min(ans, white);
        }

        return ans;
    }

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        // return brute(blocks, n, k);
        return optimal(blocks, n, k);
    }
}