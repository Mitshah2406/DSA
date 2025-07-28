class Solution {
    private boolean checkIfPossible(String word1, String word2){
        if(word1.length() != word2.length() + 1) return false;
        int first = 0, second = 0;
        while(first < word1.length()){
            if(second < word2.length() && word1.charAt(first) == word2.charAt(second)){
                first++; second++;
            } else first++;
        }

        return (first == word1.length() && word2.length() == second);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // sort by length
            } else {
                return a.compareTo(b); // lexicographical if lengths are equal
            }
        });

        int x = words.length;
        List<Integer> res = new ArrayList<>();
        int maxi = 1;

        int[] dp = new int[x];
        Arrays.fill(dp, 1);

        for(int i = 0; i < x; i++){
            for(int prevInd = 0; prevInd < i; prevInd++){
                if(checkIfPossible(words[i], words[prevInd]) && 1 + dp[prevInd] > dp[i]){
                    dp[i] = 1 + dp[prevInd];
                }

            }
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }

        // Push all the elements of hash
        return maxi;
    }
}