class Solution {

    int ans = Integer.MAX_VALUE;

    public void find(char[] p, int n, int i, int prev, StringBuilder sb, boolean[] used) {

        if (sb.length() == n + 1) {
            ans = Math.min(ans, Integer.parseInt(sb.toString()));
            return;
        }

        for (int j = 1; j <= 9; j++) {
            if (used[j]) {
                // if already number is used no point going further
                continue;
            }

            if ((p[i - 1] == 'I' && prev < j) || (p[i - 1] == 'D' && prev > j)) {
                // if i-1 of p[] is I then use prev<j {Increasing}
                // i-1 of p[] is D then use prev>j {Decreasing}
                used[j] = true; // make it used
                sb.append(j); // add to sb
                find(p, n, i + 1, j, sb, used); // proceed
                // {backtrack}
                used[j] = false; // unuse 
                sb.setLength(sb.length() - 1); // unuse
            }
        }
    }

    public String smallestNumber(String pattern) {
        ans = Integer.MAX_VALUE;
        int n = pattern.length();
        char p[] = pattern.toCharArray();
        boolean used[] = new boolean[10];
        StringBuilder sb = new StringBuilder();

        for (int j = 1; j <= 9; j++) { // coz first one doesnt have i-1,so we have to explicity find it
            used[j] = true;
            sb.append(j);
            find(p, n, 1, j, sb, used);
            used[j] = false;
            sb.setLength(0);
        }
        return Integer.toString(ans);
    }
}