class Solution {
    public void dfs(String endWord, String currWord, String beginWord, HashMap<String, Integer> hm, List<String> curr,
            List<List<String>> res) {
        curr.add(currWord);
        if (currWord.equals(beginWord)) {
            List<String> temp = new ArrayList(curr);
            Collections.reverse(temp);
            res.add(temp);
        } else {
            char currArr[] = currWord.toCharArray();
            int currLevel = hm.get(currWord);
            for (int i = 0; i < currArr.length; i++) {
                char currChar = currArr[i];

                for (int j = 0; j < 26; j++) {
                    char nextChar = (char) (j + 'a');

                    currArr[i] = nextChar;
                    String temp = new String(currArr);
                    if (hm.getOrDefault(temp, 0) == currLevel - 1) {
                        dfs(endWord, temp, beginWord, hm, curr, res);
                    }
                }
                currArr[i] = currChar;
            }
        }
        curr.remove(curr.size() - 1);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList();
        HashSet<String> hs = new HashSet();
        HashMap<String, Integer> hm = new HashMap();
        hm.put(beginWord, 1);
        q.add(beginWord);
        for (String word : wordList)
            hs.add(word);
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> wordsThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String rem = q.poll();
                int hops = hm.get(rem);

                char[] charArr = rem.toCharArray();

                for (int j = 0; j < charArr.length; j++) {
                    char originalChar = charArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        charArr[j] = c;
                        String next = new String(charArr);

                        if (hs.contains(next)) {
                            if (!hm.containsKey(next)) {
                                q.add(next);
                                hm.put(next, hops + 1);
                            }
                            wordsThisLevel.add(next);
                        }
                    }
                    charArr[j] = originalChar;
                }
            }

            hs.removeAll(wordsThisLevel);
        }

        List<List<String>> res = new ArrayList();
        if (!hm.containsKey(endWord)) {
            return res;
        }
        dfs(endWord, endWord, beginWord, hm, new ArrayList(), res);
        return res;

    }
}