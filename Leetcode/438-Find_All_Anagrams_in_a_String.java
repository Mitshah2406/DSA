class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sN = s.length();
        int pN = p.length();
        if(sN<pN) return new ArrayList();
        HashMap<Character, Integer> hmP = new HashMap();
        HashMap<Character, Integer> hmS = new HashMap();
        List<Integer> ans = new ArrayList();
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int match = 0;
        // put pattern in hm
        for(int i=0;i<pN;i++){
            hmP.put(ptr[i], hmP.getOrDefault(ptr[i],0)+1);
        }

        for(int i=0;i<pN;i++){
            hmS.put(str[i], hmS.getOrDefault(str[i], 0)+1);
            if(hmS.get(str[i]) <= hmP.getOrDefault(str[i], 0)){
                match++;
            }
        }

        if(match==pN) ans.add(0);
        int sp = 0;
        int ep = pN;
        while(ep<sN){
            hmS.put(str[ep], hmS.getOrDefault(str[ep], 0)+1);
            if(hmS.get(str[ep])<= hmP.getOrDefault(str[ep], 0)){
                match++;
            }

            hmS.put(str[sp], hmS.get(str[sp])-1);

            if(hmS.get(str[sp]) < hmP.getOrDefault(str[sp],0)){
                match--;
            }

            sp++;
            ep++;

            if(match==pN){
                ans.add(sp);
            }
        }

        return ans;
    }
}