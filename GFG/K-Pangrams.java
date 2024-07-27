class Solution {
    boolean kPangram(String s, int k) {
        s = s.replaceAll(" ", "");
        int n = s.length();
        
        HashSet<Character> hs = new HashSet();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i));
        }
        
        int unique = hs.size();

        if(n<26){
            return false;
        }
        if(unique==26){
            return true;
        }
        if(unique==n){
            return false;
        }
        if((26-unique)<=k){
            return true;
        }
        return false;
    }
}