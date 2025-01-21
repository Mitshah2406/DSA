class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int indegree[] = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        Queue<Integer> q = new LinkedList();
        for (int p[] : prerequisites) {
            int u = p[0];
            int v = p[1];
            indegree[u]++;
            ArrayList<Integer> nbrs = adj.getOrDefault(v, new ArrayList());
            nbrs.add(u);
            adj.put(v, nbrs);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int arr[] = new int[numCourses];
        int i = 0;
        while (q.size() != 0) {
            int rem = q.poll();
            arr[i++] = rem;
            ArrayList<Integer> nbrs = adj.getOrDefault(rem, new ArrayList());
            for (int nbr : nbrs) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        if(i!=numCourses){
            return new int[]{};
        }
        return arr;
    }
}