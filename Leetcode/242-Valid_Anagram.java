class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        int n = s.length();
        int m = t.length();

        if (n != m)
            return false;
        int size = 0;
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            hm.put(curr, hm.getOrDefault(curr, 0)+1);
        }
        for (int i = 0; i < n; i++) {
            char curr = t.charAt(i);
            hm.put(curr, hm.getOrDefault(curr, 0)-1);
            if(hm.get(curr)==0){
                hm.remove(curr);
            }
        }
        return hm.size()==0;
    }
}