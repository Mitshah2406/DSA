class Solution {
    String removeDups(String str) {
        int n = str.length();
        StringBuilder s = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(str.charAt(i))){
                s.append(str.charAt(i));
                hm.put(str.charAt(i), 1);
            }
        }
        return s.toString();
    }
}