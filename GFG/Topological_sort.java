class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int indegree[] = new int[V];
        
        for(int i=0;i<V;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        
        
        
        Queue<Integer> q = new LinkedList();
        // no visited as indegree==0 satisfies visited constraint as well
        ArrayList<Integer> arr = new ArrayList();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(q.size()!=0){
            int rem = q.poll();
            arr.add(rem);
            
            for(int nbr : adj.get(rem)){
                indegree[nbr]--;
                if(indegree[nbr]==0){ // using this as visited thing as well for indegree
                    q.add(nbr);
                }
            }
        }
        
        
        
        return arr;
    }
}