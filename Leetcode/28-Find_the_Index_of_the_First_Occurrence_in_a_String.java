class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m)
            return -1;
        int j = 0;
        int i = 0;
        while (i < n) {
            char curr = haystack.charAt(i);
            // System.out.println(i);
            if (curr == needle.charAt(j)) {
                // start
                // System.out.println("Checking " +i);
                boolean isFirst = true;
                while(j<m) {
                    if (i+j>=n || haystack.charAt(i + j) != needle.charAt(j)) {
                        isFirst = false;
                        break;
                    }
                    j++;
                }
                j=0;
                if (isFirst)
                    return i;
            }

            i++;
        }

        return -1;
    }
}