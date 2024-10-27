class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int count = 0;
        int noSt = stations.length;
        int currPt = 0;
        int currFuel = startFuel;
        
        int done = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (currPt < target && currFuel > 0) {
            currPt += currFuel;
            currFuel = 0;

            for (int i = done; i < noSt; i++) {
                if (currPt >= stations[i][0]) {
                    pq.add(stations[i][1]);
                    done++;
                }
            }
        
            if (currPt < target) {
                if (pq.size() == 0) {
                    return -1;
                }
                currFuel += pq.remove();
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}