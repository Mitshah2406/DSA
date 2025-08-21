
class Solution {
    public int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int e: arr){
            hm.put(e,hm.getOrDefault(e,0)+1);
        }
        
        for(int e: arr){
            if(hm.get(e)==1){
                return e;
            }
        }
        return 0;
    }
}
