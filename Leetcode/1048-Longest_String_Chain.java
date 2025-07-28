class Solution {
    public boolean check(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < n) {
            if (second < m && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return (first == n && second == m);
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        // Intution is first we can sort, because we want sequence in any order
        // then we use lis as longest chaining sequence (lis>(string matching, similar to lcs)
        // Time - O(nlogn*k) + O(n^2*k)  = O(n^2*k) [k is length of an string]
        // Space - O(n)
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            } else {
                return a.compareTo(b);
            }
        });

        int dp[] = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
