// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // Time - O(v+e) {outer loop atleast run V times, inner loop for neighbour at an avg run e times for edges}
        // Space - O(3v) ~ O(v) {Queue, res arr, vis arr}
        Queue<Integer> q = new LinkedList();
        ArrayList<Integer> arr = new ArrayList();
        boolean vis[] = new boolean[V];
        q.add(0);
        vis[0] = true;
        while(q.size()!=0){
            int rem = q.poll();
            arr.add(rem);
            for(int nbr : adj.get(rem)){
                if(!vis[nbr]){
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        
        return arr;
    }
}