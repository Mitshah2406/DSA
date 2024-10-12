class Pair {
    int busStop;
    int noOfBusesBoarded;

    public Pair(int busStop, int noOfBusesBoarded) {
        this.busStop = busStop;
        this.noOfBusesBoarded = noOfBusesBoarded;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        // routes[][] is Bus No -> Stops
        int noOfBuses = routes.length;
     
        // Bus Stop -> Bus No
        HashMap<Integer, ArrayList<Integer>> busStopToBusNo = new HashMap();

        // Prepare HashMap
        for (int i = 0; i < noOfBuses; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> arr = busStopToBusNo.getOrDefault(routes[i][j], new ArrayList());
                arr.add(i);
                busStopToBusNo.put(routes[i][j], arr);
            }
        }

        // BFS Queue (Bus Stop --> Bus Count)
        Queue<Pair> q = new LinkedList();

        q.add(new Pair(source, 0));

        // Visited Bus No Hashset
        HashSet<Integer> visBuses = new HashSet();
        // Visited Bus Stops Hashset
        HashSet<Integer> visBusStops = new HashSet();

        while (q.size() > 0) {
            Pair rem = q.remove();
            if(rem.busStop==target){
                return rem.noOfBusesBoarded;
            }
            visBusStops.add(rem.busStop);

            ArrayList<Integer> buses = busStopToBusNo.getOrDefault(rem.busStop, new ArrayList());

            for (int bus : buses) {
                if (!visBuses.contains(bus)) {
                    visBuses.add(bus);
                    for (int i = 0; i < routes[bus].length; i++) {
                        if (!visBusStops.contains(routes[bus][i])) {
                            visBusStops.add(routes[bus][i]);
                            q.add(new Pair(routes[bus][i], rem.noOfBusesBoarded+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}