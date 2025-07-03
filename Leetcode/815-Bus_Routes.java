class Solution {
    // Time Complexity: O(N * K), where
    //    N = number of routes (buses),
    //    K = maximum number of stops per route.
    // Space Complexity: O(N * K + S), where
    //    S = total number of unique stops across all routes.
    
    class Pair {
        int busStop;
        int noOfBuses;
        public Pair(int busStop, int noOfBuses) {
            this.busStop = busStop;
            this.noOfBuses = noOfBuses;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int nBuses = routes.length;

        // Mapping each bus stop to the list of buses (routes) that pass through it
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nBuses; i++) {
            int r[] = routes[i];
            for (int busStop : r) {
                hm.computeIfAbsent(busStop, x -> new ArrayList<>()).add(i);
            }
        }

        HashSet<Integer> busesVisited = new HashSet<>();     // Tracks visited bus routes
        HashSet<Integer> busStopsVisited = new HashSet<>();  // Tracks visited bus stops

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, 0));
        busStopsVisited.add(source);

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            int busStop = rem.busStop;
            int noOfBuses = rem.noOfBuses;

            if (busStop == target) {
                return noOfBuses;
            }

            ArrayList<Integer> buses = hm.getOrDefault(busStop, new ArrayList<>());

            for (int bus : buses) {
                if (!busesVisited.contains(bus)) {
                    busesVisited.add(bus);
                    int[] busStops = routes[bus];
                    for (int bs : busStops) {
                        if (!busStopsVisited.contains(bs)) {
                            q.add(new Pair(bs, noOfBuses + 1));
                            busStopsVisited.add(bs);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
