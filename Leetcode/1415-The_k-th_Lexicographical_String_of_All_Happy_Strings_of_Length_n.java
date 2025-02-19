class Solution {
    int limit = 0;
    String ans = "";

    public void find(StringBuilder sb, int n, int i, int k) {
        if (limit == k-1) {
            ans = sb.toString();
        }
        if (sb.length() == n) {
            limit++;
            return;
        }

        for (int j = 0; j < 3; j++) {
            char curr = (char) (j + (int) 'a');
            if (sb.charAt(i - 1) == curr) {
                continue;
            }
            sb.append(curr);
            find(sb, n, i + 1, k);
            sb.setLength(sb.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        limit = 0;
        ans = "";
        if (n == 1) {
            if (k == 1)
                return "a";
            else if (k == 2)
                return "b";
            else if(k==3)
                return "c";
        }
       
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char curr = (char) (i + (int) 'a');

            sb.append(curr);
            find(sb, n, 1, k);
            sb.setLength(0);
        }

        return ans;
    }
}