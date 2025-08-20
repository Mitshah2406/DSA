class Solution {
    public String minWindow(String s, String t) {
        /**
        BRUTE FORCE - Time - O(n^2), Space - O(256)
        Simple nested loop soln
         */


        /**
        OPTIMAL
        Time = O(2N), Space = O(256)
        Take a  map[256] 
        Take inital frequencies by incrementing in map,
        then in the window
        inserting means DECREMENT, removing means INCREMENT
        first, just insert all chars of t,
        then run a sliding window, in that add each character, if it was >0 means a valid character is being added to window (currCnt++)

        if we have a valid window (currCnt==m), then just try pruning from left, basically incrementing in map,
        if someone goes above 0, then we pruned a valid char, so decrement currCnt ctr

        keep checking and updating minLen and startIdx in the process,
        finally if startIdx never updated return "", else return substring from startIdx to startIdx+minLen
         */
        int n = s.length();
        int m = t.length();
        int minLen = (int)1e9;
        int startIdx = -1;
        int map[] = new int[256];
        for (int i=0;i<m;i++) {
            map[t.charAt(i)]++; // to ensure that only valid chars are > 0
        }
        int left = 0;
        int right = 0;
        int currCnt = 0;
        while (right < n) {
            char curr = s.charAt(right);
            if(map[curr]>0){ // if it was a valid character, increase currCnt
                currCnt++;
            }
            map[curr]--;

            while(currCnt==m){
                char toBeChecked = s.charAt(left);
                if((right-left+1)<minLen){
                    minLen = (right-left+1);
                    startIdx = left;
                }
                map[toBeChecked]++;
                if(map[toBeChecked]>0){
                    // means increase currCnt, because we removed a valid character
                    currCnt--;
                }
                left++;
            }

            right++;
        }

        return startIdx==-1 ? "" : s.substring(startIdx, startIdx+minLen);
    }
}