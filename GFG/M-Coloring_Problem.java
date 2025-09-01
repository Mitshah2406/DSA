class Solution {
    /*
      Intuition:
      This is a classic backtracking solution for graph coloring.
      Idea is simple - we try to assign a color to each node one by one.
      For every node, we loop over all available colors (from 0 to m-1),
      and check if it's safe to assign that color.
      Safe means none of its neighbors have that same color (checked in possible()).
      If it's safe, we assign the color and move to the next node recursively.
      If at some point we cannot assign any color, we backtrack (reset color to -1).
      If we manage to color all nodes, return true, else false.

      The recursion basically explores all possible color assignments, but
      with pruning because we never assign a color that clashes with neighbors.

      Time complexity:
      Worst case is O(m^v) because for every node we may try all m colors.
      The "possible" function checks all neighbors, so you can also say
      O(v * m * deg) where deg is average degree, but big-O wise it's exponential.

      Space complexity:
      O(v + e) for adjacency list storage,
      plus O(v) for the colors array,
      plus recursion stack up to O(v).
      So overall O(v + e).

      In short: brute force with pruning, exponential in worst case,
      but works fine for small graphs.
    */
    private boolean solve(int node, int n, int totalColors, ArrayList<ArrayList<Integer>> adj, int totalEdges, int colors[]){
        if(node==n){
            return true;
        }
        
        for(int c=0;c<totalColors;c++){
            if(possible(node, c, adj, colors)){
                colors[node] = c;
                if(solve(node+1, n, totalColors, adj, totalEdges, colors)){
                    return true;
                }
                colors[node] = -1;
            }
        }
        return false;
    }
    private boolean possible(int node, int color, ArrayList<ArrayList<Integer>> adj, int[] colors){
        ArrayList<Integer> nbrs = adj.get(node);
        
        for(int nbr: nbrs){
            if(colors[nbr]==color){
                return false;
            }
        }
        return true;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int colors[] = new int[v];
        Arrays.fill(colors,-1);
        int e = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int x = edge[0];
            int y = edge[1];
            
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return solve(0, v, m, adj, e, colors);
    }
}
