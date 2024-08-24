class Sol
{
    int isPossible (String S)
    {
        HashMap<Character, Integer> hm = new HashMap();
        
        char[] str = S.toCharArray();
        
        for(char c : str){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        boolean oddExist = false;
        int oddCount = 0;
        for(Map.Entry<Character, Integer> e: hm.entrySet()){
            int val = e.getValue();
            if(val%2==1){
                oddExist=true;
                if(oddCount>=1){
                    return 0;
                }
                oddCount++;
            }
        }
        
        return 1;
    }
}