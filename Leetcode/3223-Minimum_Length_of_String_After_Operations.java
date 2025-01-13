class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if(n<=2){
            return n;
        }

        int c = n;
        // just store frequencies and when u get 3 chop off the count by 2
        int hm[] = new int[26];
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);

            hm[curr-'a']++;
            if(hm[curr-'a']==3){
                hm[curr-'a']=1;
                c-=2;
            }
        }


        return c;
    }
}