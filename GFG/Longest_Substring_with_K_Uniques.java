class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        if(k>n) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int ans = -1;
        for(int right=0;right<n;right++){
            char curr = s.charAt(right);
            hm.put(curr, hm.getOrDefault(curr,0)+1);
            
            if(left<right && hm.size()>k){
                while(hm.size()!=k){
                    char temp = s.charAt(left);
                    int val = hm.get(temp);
                    if(val-1 == 0){
                        hm.remove(temp);
                    }else{
                        hm.put(temp, val-1);
                    }
                    left++;
                }
            }
            
            if(hm.size()==k){
                ans = Math.max(right-left+1,ans);
            } 
        }
        
        return ans;
    }
}
