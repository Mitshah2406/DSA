class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // Time Complexity:
        // - Building adjacency list: O(paths.length)
        // - BFS traversal of all nodes and edges: O(n + paths.length)
        // - For each garden, checking neighbors (max 3) takes O(1)
        // So overall TC = O(n + paths.length)

        // Space Complexity:
        // - Adjacency list: O(n + paths.length)
        // - Queue for BFS: O(n)
        // - Visited/color array: O(n)
        // So overall SC = O(n + paths.length)

        // Construction
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList());
        }

        for(int i = 0; i < paths.length; i++){
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }

        Queue<Integer> q = new LinkedList();
        int vis[] = new int[n + 1]; 
        // Values: 0 = unvisited, 1-4 = flower types

        // Disconnected graph - mutli src BFS
        for(int i = 1; i <= n; i++){
            if(vis[i] == 0){
                q.add(i);

                while(!q.isEmpty()){
                    int rem = q.poll();

                    // Keep track of flower types used by neighbors
                    boolean used[] = new boolean[5]; // index 1..4

                    for(int nbr : adj.get(rem)){
                        if(vis[nbr] != 0){
                            used[vis[nbr]] = true;
                        }
                    }

                    // Assign the first available flower type
                    for(int c = 1; c <= 4; c++){
                        if(!used[c]){
                            vis[rem] = c;
                            break;
                        }
                    }

                    // Enqueue unvisited neighbors for BFS
                    for(int nbr : adj.get(rem)){
                        if(vis[nbr] == 0){
                            q.add(nbr);
                        }
                    }
                }
            }
        }

        // Prepare result array, skipping dummy index 0
        int res[] = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = vis[i + 1];
        }
        return res;
    }
}
