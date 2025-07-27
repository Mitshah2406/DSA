class Solution {
    public boolean find(int currStone, int lJ, int n, int stones[], HashMap<Integer, Integer> hm, Boolean dp[][]) {
        if (currStone >= n || !hm.containsKey(stones[currStone] + lJ)) {
            return false;
        }
        if (stones[currStone] + lJ == stones[n - 1]) {
            return true;
        }

        if (dp[currStone][lJ] != null) {
            return dp[currStone][lJ];
        }
        boolean ans = false;
        int lJM1 = lJ - 1;
        int toGo = hm.get(stones[currStone] + lJ);
        if (lJM1 > 0) {
            ans = ans || find(toGo, lJM1, n, stones, hm, dp);
        }
        int lJP1 = lJ + 1;
        int lJSame = lJ;
        if (lJSame != 0) {
            ans = ans || find(toGo, lJSame, n, stones, hm, dp);
        }
        return dp[currStone][lJ] = ans || find(toGo, lJP1, n, stones, hm, dp);
    }

    public boolean canCross(int[] stones) {
        // int n = stones.length;
        // Boolean dp[][] = new Boolean[n + 1][n + 1];
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for (int s = 0; s < n; s++) {
        //     hm.put(stones[s], s);
        // }
        // return find(0, 0, n, stones, hm, dp);

        // Tabulate

        int n = stones.length;
        Boolean dp[][] = new Boolean[n + 1][n + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int s = 0; s < n; s++) {
            hm.put(stones[s], s);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][n] = false;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int lJ = n - 1; lJ >= 0; lJ--) {
                if (stones[i] + lJ == stones[n - 1]) {
                    dp[i][lJ] = true;
                    continue;
                }
                if (!hm.containsKey(stones[i] + lJ)) {
                    dp[i][lJ] = false;
                    continue;
                }

                boolean ans = false;
                int lJM1 = lJ - 1;
                int toGo = hm.get(stones[i] + lJ);
                if (lJM1 > 0) {
                    ans = ans || dp[toGo][lJM1];
                }
                int lJP1 = lJ + 1;
                int lJSame = lJ;
                if (lJSame != 0) {
                    ans = ans || dp[toGo][lJSame];
                }
                dp[i][lJ] = ans || dp[toGo][lJP1];
            }
        }

        return dp[0][0];
    }
}