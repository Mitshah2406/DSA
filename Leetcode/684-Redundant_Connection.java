class DisjointSet {
    int parent[];
    int rank[];
    int size;
    int indexing = 0;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        this.size = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX == parY)
            return false;

        if (rank[parX] > rank[parY]) {
            parent[parY] = parX;
        } else if (rank[parY] > rank[parX]) {
            parent[parX] = parY;
        } else {
            parent[parX] = parY;
            rank[parY]++;
        }
        return true;
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;

        int p = find(parent[x]);
        parent[x] = p;
        return p;
    }

    public int countComponents() {
        int st = indexing == 0 ? 0 : 1;
        int cnt = 0;
        for (int i = st; i < size; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet dsu = new DisjointSet(n+1);
        dsu.indexing=1;
        int res[] = new int[2];
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];

            if(!dsu.union(u,v)){ // if the vertices are already in same component. i.e have same parent the edge will be rejected.. we have to return the last edge
                res[0]=u;res[1]=v;
            }
        }
        return res;
    }
}