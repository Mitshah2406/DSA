/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
    PriorityQueue<iPair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.second, b.second));
      q.add(new iPair(src,0));
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        while(q.size()!=0){
            iPair rem = q.poll();
            if(rem.second<dist[rem.first]){
                dist[rem.first] = rem.second;
            }
            
            for(iPair ip : adj.get(rem.first)){
                int nVtx = ip.first;
                int cost = ip.second;
                
                if(cost+rem.second<dist[nVtx]){
                    q.add(new iPair(nVtx, cost+rem.second));
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList();
        for(int i=0;i<n;i++){
            arr.add(dist[i]);
        }
        return arr;
        
    }
}