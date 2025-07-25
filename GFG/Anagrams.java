class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        if(n!=m){
            return false;
        }
        
        int[] count = new int[26]; // assuming only lowercase letters

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
    
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
    
        return true;
    }
}
