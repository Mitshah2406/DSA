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

    /*
        ==> Time Complexity - O(ElogE) {maximum e things can be added in pq} + {pq insertion time i.e logn i.e loge}
        O(ElogE) {E = V^2 ; coz a complete graph can have (V(V-1))/2 edges i.e V^2 edges . Hence O(E) = O(V^2)}
        O(ElogV^2) { loga^2 = 2loga = Logarithm property}
        hence O(ElogE) ~ O(ElogV^2) ~ O(2ElogV) ~ O(ElogV)

        ==> Space Complexity - O(E) as PQ holds E edges

        ==> Note - Only works for non negative graphs coz we dont overwrite the distances once done. if we do it will increase TC.
    */
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
    PriorityQueue<iPair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.second, b.second));
      q.add(new iPair(src,0));
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        while(q.size()!=0){
            iPair rem = q.poll();
            if(dist[rem.first]==Integer.MAX_VALUE){
                dist[rem.first] = rem.second;
            }else{
                continue;
            }
            for(iPair ip : adj.get(rem.first)){
                int nVtx = ip.first;
                int cost = ip.second;
                if(dist[nVtx]!=Integer.MAX_VALUE) continue;
                q.add(new iPair(nVtx, cost+rem.second));
            }
        }
        ArrayList<Integer> arr = new ArrayList();
        for(int i=0;i<n;i++){
            arr.add(dist[i]);
        }
        return arr;
        
    }
}
