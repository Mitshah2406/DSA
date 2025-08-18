class Solution {
    public int longestKSubstr(String s, int k) {
        /*
        BETTER Solution
        O(2N), O(1)
        Dynamic size sliding window, with a hashmap to store frequencies
        */
        // HashMap<Character, Integer> hm = new HashMap<>();
        
        // int n = s.length();
        
        // int left = 0;
        // int right = 0;
        // int ans = -1;
        // while(right<n){
        //     char curr = s.charAt(right);
        //     hm.put(curr, hm.getOrDefault(curr,0)+1);
            
        //     while(hm.size()>k){
        //         // remove left
        //         char l = s.charAt(left);
        //         int val = hm.get(l);
        //         val--;
        //         if(val>0){
        //             hm.put(l,val);
        //         }else{
        //             hm.remove(l);
        //         }
                
        //         left++;
        //     }
        //     if(hm.size()==k){
        //         ans = Math.max(ans, right-left+1);
        //     }
        //     right++;
            
        // }
        // return ans;
        
        
        /*
        OPTIMAL Solution
        O(N), O(1)
        Dynamic size sliding window, with a hashmap to store frequencies
        Just removed the inner loop, replaced with if statement,
        and added a check for updating the ans, as ans will never decrease 
        from the length it has
        So no point in pruning whole left, that anyways gonna not become whole ans
        
        aaabbccd, k=2
         l   r
        till c max len recorded was 5, once we get c, we move l one time forward
        a's are invalid but that doesnt anyways affect our answer, we are just 
        preventing the window to be pruned from less than 5
        
        */
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int n = s.length();
        
        int left = 0;
        int right = 0;
        int ans = -1;
        while(right<n){
            char curr = s.charAt(right);
            hm.put(curr, hm.getOrDefault(curr,0)+1);
            
            if(hm.size()>k){
                // remove left
                char l = s.charAt(left);
                int val = hm.get(l);
                val--;
                if(val>0){
                    hm.put(l,val);
                }else{
                    hm.remove(l);
                }
                
                left++;
            }
            if(hm.size()==k){
                ans = Math.max(ans, right-left+1);
            }
            right++;
            
        }
        return ans;
    }
}
