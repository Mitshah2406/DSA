/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       int indegree[] = new int[V];
       
       for(int i=0;i<V;i++){
           for(int val : adj.get(i)){
               indegree[val]++;
           }
       }
       
       Queue<Integer> q = new LinkedList();
       for(int i=0;i<V;i++){
           if(indegree[i]==0){
               q.add(i);
           }
       }
        int done = 0;
       while(q.size()!=0){
           int rem = q.poll();
           done++;
           for(int nbr:adj.get(rem)){
               indegree[nbr]--;
               if(indegree[nbr]==0){
                   q.add(nbr);
               }
           }
       }

       if(done==V){
           return false;
       }else{
           return true;
       }
    }
}