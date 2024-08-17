class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap();

        for(List<Integer> w: wall){
            int p = 0;
            for(int i=0;i<w.size()-1;i++){
                p+=w.get(i);
                hm.put(p, hm.getOrDefault(p, 0)+1);
            }
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){

            max = Math.max(max, e.getValue());
        }

        return wall.size()-max;
    }
}