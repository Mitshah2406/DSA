class Solution {
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if(tLen>sLen){
            return "";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> tMap = new HashMap();
        HashMap<Character, Integer> sMap = new HashMap();

        for (int i=0;i<tLen;i++) {
            tMap.put(tArr[i], tMap.getOrDefault(tArr[i], 0) + 1);
        }

        int sp = 0;
        int ep = 0;
        int ans = Integer.MAX_VALUE;
        int matchCount = 0;
        int subStart = 0;
        int subEnd = 0;
        while(ep<sLen){
            if(matchCount==tLen){
                if(ep-sp<ans){
                    ans = ep-sp;
                    subStart = sp;
                    subEnd = ep;
                }
                sMap.put(sArr[sp], sMap.get(sArr[sp])-1);

                if(sMap.get(sArr[sp])<tMap.getOrDefault(sArr[sp],0)){
                    matchCount--;
                }
                sp++;
            }else{
                sMap.put(sArr[ep], sMap.getOrDefault(sArr[ep], 0)+1);

                if(sMap.get(sArr[ep])<=tMap.getOrDefault(sArr[ep], 0)){
                    matchCount++;
                }

                ep++;
            }
        }
        while(matchCount==tLen){
            if(matchCount==tLen){
                if(ep-sp<ans){
                    ans = ep-sp;
                    subStart = sp;
                    subEnd = ep;
                }
                sMap.put(sArr[sp], sMap.get(sArr[sp])-1);

                if(sMap.get(sArr[sp])<tMap.getOrDefault(sArr[sp],0)){
                    matchCount--;
                }
                sp++;
            }
        }
        return s.substring(subStart, subEnd);
    }
}