class Solution {
    public int minimumPushes(String word) {
        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets, 0);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            alphabets[c - 'a']++;
        }
        Arrays.sort(alphabets, Collections.reverseOrder());

        int count = 0;
        int level = 0;
        int res = 0;


        for(int i=0;i<26 && alphabets[i]!=0;i++){
            if(count%8==0){
                level++;
            }
            res += (level*alphabets[i]);
            count++;
        }

        return res;
    }
}
