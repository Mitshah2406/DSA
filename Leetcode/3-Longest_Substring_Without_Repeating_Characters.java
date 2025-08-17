class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        Brute Force
        O(n^3) , O(1)
         */
        // int n = s.length();
        // int max = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=n-1;j>=i;j--){
        //         int map[] = new int[256];
        //         boolean flag = true;
        //         for(int k=i;k<=j;k++){
        //             if(map[s.charAt(k)]<1){
        //                 map[s.charAt(k)]++;
        //             }else{
        //                 flag = false;
        //                 break;
        //             }
        //         }

        //         if(flag) max = Math.max(max, j-i+1);
        //     }
        // }

        // return max;

        /**
        BETTER
        Intuition - Keep a CharacterXFrequency Map
        and keep a left and right ptr, and keep pruning the left pointer

        O(n), O(N)
         */

        // int n = s.length();
        // int max = 0;

        // int left = 0;
        // HashMap<Character, Integer> hm = new HashMap<>();

        // for(int right=0;right<n;right++){
        //     char curr = s.charAt(right);
        //     hm.put(curr, hm.getOrDefault(curr,0)+1);
        //     // prune the window
        //     while(hm.get(curr)>1){
        //         char rem = s.charAt(left);
        //         int val = hm.get(rem);
        //         hm.put(rem, val-1);
        //         left++;
        //     }
        //     max = Math.max(right-left+1, max);
        // }
        // return max;

        /**
        OPTIMAL
        O(N), O(N)

        Change the map to CharacterXLastSeenIdx
        So that inner loop eliminates, we directly jump to lastSeen+1 idx for left pruning

        condition is lastSeen>=left coz when jumping some other characters can also be pruned which are in the map
         */
        int n = s.length();
        int max = 0;

        int left = 0;
        HashMap<Character, Integer> hm = new HashMap<>(); // Char X last seen idx

        for(int right=0;right<n;right++){
            char curr = s.charAt(right);
            int getLastSeenIdx = hm.getOrDefault(curr,-1);
            // prune the window
            if(getLastSeenIdx>=left){
                left = getLastSeenIdx+1;
            }
            hm.put(curr,right);
            max = Math.max(right-left+1, max);
        }
        return max;
    }
}