class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        if (n < 3) {
            return 0;
        }

        int ans = 0;
        
        int map[] = new int[3];
        int left = 0; // window start
        for(int right=0;right<n;right++){ // looping on window 
            map[s.charAt(right)-'a']++; 

            while(map[0]> 0 && map[1]> 0 && map[2]> 0){
                // once all three are there, count no of substrings possible from that
                 ans += (n-right);

                 // rem last char

                 map[s.charAt(left)-'a']--;
                 left++;
            }
        }

        return ans;
    }
}