class Solution {
    class Pair {
        String word;
        int hops;

        public Pair(String word, int hops) {
            this.word = word;
            this.hops = hops;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
            Modified version of bfs
         */

        HashSet<String> hs = new HashSet();
        for (String s : wordList) {
            hs.add(s);
        }

        Queue<Pair> q = new LinkedList();
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair rem = q.poll();

            String currWord = rem.word;
            int currHops = rem.hops;
            if (currWord.equals(endWord)) {
                return currHops;
            }
            // explore nbrs
            char charArr[] = currWord.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                // change each char to (a-z) and check in hs if it exist
                char curr = charArr[i];
                for (int j = 0; j < 26; j++) {
                    charArr[i] = (char)(j+'a');
                    String check = new String(charArr);
                    if (hs.contains(check)) {
                        hs.remove(check);
                        q.add(new Pair(check, currHops + 1));
                    }
                }

                charArr[i] = curr;
            }
        }
        return 0;
    }
}