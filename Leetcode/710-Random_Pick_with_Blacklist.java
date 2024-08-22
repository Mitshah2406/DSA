class Solution {
    HashMap<Integer, Integer> hm;
    Random r;
    int valid;
    public Solution(int n, int[] blacklist) {

        hm = new HashMap();
        r = new Random();

        for(int i=0;i<blacklist.length;i++){
            hm.put(blacklist[i], -1);
        }
      valid = n - blacklist.length;

        for(int i=0;i<blacklist.length;i++){
            if(blacklist[i]<valid){
                while(hm.containsKey(n-1)){
                    n--;
                }
                hm.put(blacklist[i], n-1);
                n--;
            }
        }
    }
    
    public int pick() {
        int idx = r.nextInt(valid);
        if(hm.containsKey(idx)){
            return hm.get(idx);
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */