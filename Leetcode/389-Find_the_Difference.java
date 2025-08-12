class Solution {
    private int checkBit(int n, int k) {
        return (n & (1 << k)) != 0 ? 1 : 0;
    }

    public char findTheDifference(String s, String t) {
        // int n = s.length();
        // int m = t.length();

        // int map[] = new int[26];

        // for(int i=0;i<n;i++){
        //     map[s.charAt(i)-'a']++;
        // }

        // for(int i=0;i<m;i++){
        //     char curr = t.charAt(i);
        //     map[curr-'a']--;
        //     if(map[curr-'a']<0){
        //         return curr;
        //     }
        // }

        // return 'a';


        // int n = s.length();
        // int m = t.length();

        // int map[] = new int[32];

        // for (int i = 0; i < n; i++) {
        //     char currA = s.charAt(i);
        //     char currB = t.charAt(i);
        //     for (int j = 0; j < 32; j++) {
        //         map[j] -= checkBit(currA - 'a', j);
        //         map[j] += checkBit(currB - 'a', j);
        //     }
        // }
        // for (int j = 0; j < 32; j++) {
        //     map[j] += checkBit(t.charAt(n) - 'a', j);
        // }

        // int decimal = 0;
        // for (int i = 0; i < 32; i++) {
        //     decimal |= (map[i] << i);
        // }

        // return (char)(decimal + (int) 'a');

        // Time - O(n+m), Space - O(1)
        int n = s.length();
        int m = t.length();
        int ans = 0;
        // just do xor, dups will be removed only the added character will remain
        for(int i=0;i<n;i++){
            ans^=s.charAt(i);
        }
        for(int i=0;i<m;i++){
            ans^=t.charAt(i);
        }
        return (char) ans;
    }
}