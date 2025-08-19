class Solution {
    public int numberOfSubstrings(String s) {
        /**
        BRUTE FORCE
        Time = O(n^2)
        Space = O(3)
         */
        // int ans = 0;
        // int n = s.length();
        // for (int i = 0; i < n; i++) {
        //     int map[] = new int[3];
        //     for(int j=i;j<n;j++){
        //         map[s.charAt(j)-'a'] = 1;

        //         if(map[0]+map[1]+map[2]==3){
        //             ans++;
        //         }
        //     }
        // }
        // return ans;

        /**
        BETTER 
        Time = O(n^2)
        Space = O(3)
        
        Optimisation is 
        
        abcabc , j=2, we get a valid substring starting from i=0(a), so we do not need to go further,
        we can straight add the rest of substrings starting from i=0 to 3,4,5; as all will be valid
        
        therefore instead ans++; do ans+=(n-j) [6-2] = 4 and break
         */
        // int ans = 0;
        // int n = s.length();
        // for (int i = 0; i < n; i++) {
        //     int map[] = new int[3];
        //     for(int j=i;j<n;j++){
        //         map[s.charAt(j)-'a'] = 1;

        //         if(map[0]+map[1]+map[2]==3){
        //             ans = ans + (n-j);
        //             break;
        //         }
        //     }
        // }
        // return ans;

        /**
        OPTIMAL 
        Time = O(n)
        Space = O(3)
        
        Optimisation is 
        Consider endpoints, at any i, and see if in lastSeen map, every character is there, 
        the minimum idx in map, is the minimum start point we need for a valid
        substring

        eg = bbacba, at i =3, we have [a=2,b=1,c=3], min is idx = 1 for b, 
        therefore, the previous substring including current can be included
        because everyone ends at i=3, which is valid
        therefore number of substrings ans+=(1+min(a,b,c));
         */
        int lastSeen[] = new int[3];
        lastSeen[0] = lastSeen[1] = lastSeen[2] = -1;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i)-'a']=i;

            // if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
            //     ans += (1+Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2])));
            // }
            // Can eliminate if, because if anyone is -1, min will always return that 
            // and (1+(-1)) is always 0;
            ans += (1+Math.min(lastSeen[0], Math.min(lastSeen[1],lastSeen[2])));
        }
        return ans;
    }
}