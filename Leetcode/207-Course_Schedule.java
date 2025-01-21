class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int indegree[] = new int[numCourses];

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        Queue<Integer> q = new LinkedList();
        for (int p[] : prerequisites) {
            int u = p[0];
            int v = p[1];
            indegree[v]++;
            ArrayList<Integer> nbrs = adj.getOrDefault(u, new ArrayList());
            nbrs.add(v);
            adj.put(u, nbrs);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int done = 0;
        while (q.size() != 0) {
            int rem = q.poll();
            done++;
            ArrayList<Integer> nbrs = adj.getOrDefault(rem, new ArrayList());
            for (int nbr : nbrs) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (done == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}