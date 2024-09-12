class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<26 && i<allowed.length();i++){
            hs.add(allowed.charAt(i));
        }
        int ans=words.length;
        for(String word : words){
            // char[] ch = word.toCharArray();
            for(int i=0;i<word.length();i++){
                if(!hs.contains(word.charAt(i))){
                    ans-=1;
                    break;
                }
            }
        }

        return ans;
    }
}