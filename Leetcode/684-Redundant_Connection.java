class DisjointSet {
    public int parent[];
    public int rank[];

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean unionByRank(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX == parY)
            return false;

        if (rank[parX] > rank[parY]) {
            parent[parY] = parX;
        } else if (rank[parY] > rank[parX]) {
            parent[parX] = parY;
        } else {
            parent[parY] = parX;
            rank[parX]++;
        }

        return true;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];

            boolean merge = ds.unionByRank(u,v);
            if(!merge){
                return edge;
            }
        }

        return new int[]{};
    }
}