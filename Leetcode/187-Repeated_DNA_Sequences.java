class Solution {
    /**
     Time Complexity:  O(10n) 
     For each index, we build at most one substring of length 10.
     HashSet operations (add/contains) are O(1) average.
    
     Space Complexity: O(n)
     HashSets store up to (n-9) substrings of length 10.
     Extra space from StringBuilder is O(1).
    */
    private void brute(String s, int n, List<String> ans) {
        HashSet<String> hs = new HashSet<String>();
        HashSet<String> ansHs = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                if (j - i + 1 == 10) {
                    String check = sb.toString();
                    if (hs.contains(check)) {
                        ansHs.add(check);
                    }
                    hs.add(check);
                    break;
                }
            }
        }
        ans.addAll(ansHs);
    }

    /**
      Time Complexity:  O(n)
      Sliding window across string, each step does O(1) work 
          (delete, append, toString, hashset ops).
     
      Space Complexity: O(n)
      HashSets may store up to (n-9) substrings.
      StringBuilder remains fixed size (10) -> O(1).
     */

    private void optimal(String s, int n, List<String> ans) {
        HashSet<String> hs = new HashSet<String>();
        HashSet<String> ansHs = new HashSet<String>();
        StringBuilder sb = new StringBuilder(s.substring(0, 10)); // first window
        hs.add(sb.toString());
        for (int i = 10; i < n; i++) {
            // remove i-k
            sb.deleteCharAt(0);
            sb.append(s.charAt(i)); // add current window char

            // check if repeated
            String check = sb.toString();
            if (hs.contains(check)) {
                ansHs.add(check);
            }
            hs.add(check);
        }

        ans.addAll(ansHs);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if (n < 10)
            return ans;
        // brute(s, n, ans);
        optimal(s, n, ans);
        return ans;
    }
}