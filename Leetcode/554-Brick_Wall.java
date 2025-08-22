class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int n = wall.size();
        
        int totalWidth = 0;
        int maxWallEndingsPos = 0;
        for(int i : wall.get(0)){
            totalWidth+=i;
        }
        int ans = 0;
        for (List<Integer> layer : wall) {
            int currentPos = 0;
            for (int i = 0; i < layer.size() - 1; i++) {
                currentPos += layer.get(i);
                hm.put(currentPos, hm.getOrDefault(currentPos, 0) + 1);
                ans = Math.max(ans, hm.get(currentPos));
            }
        }
        return n-ans;
    }
}

// X X
// XX
// X X