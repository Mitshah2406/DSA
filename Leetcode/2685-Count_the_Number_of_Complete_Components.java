class Solution {
    /*
        Union By Size
        1) Just do the union, 
        2) then store the edges as LEADERxEDGE_COUNT map
        3) then check if you get parent, against complete graph edge formula and map's edge count


        Time = O(E*O(alpha n)) + O(E*O(alpha n)) + O(E) {Union + Find + Count Check}
        Space = O(N) for edge count map
     */
    class DisjointSet {
        int size[];
        int parent[];
        int n;

        public DisjointSet(int n) {
            this.n = n;
            this.size = new int[n];
            this.parent = new int[n];

            for (int i = 0; i < n; i++) {
                this.size[i] = 1;
                this.parent[i] = i;
            }
        }

        private int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            int t = find(parent[x]);
            parent[x] = t;
            return t;
        }

        public boolean union(int x, int y) {
            int ux = find(x);
            int uy = find(y);

            if (ux == uy) {
                return false;
            }
            if (size[ux] > size[uy]) {
                parent[uy] = ux;
                size[ux] += size[uy];
            } else {
                parent[ux] = uy;
                size[uy] += size[ux];
            }

            return true;
        }

        public int countComps() {
            int cnt = 0;
            for (int i = 0; i < this.n; i++) {
                if (parent[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);

        for (int edge[] : edges) {
            dsu.union(edge[0], edge[1]);
        }
        HashMap<Integer, Integer> hm = new HashMap(); // leader x count of edges
        for (int edge[] : edges) {
            int u = edge[0];
            int parentComp = dsu.find(u);
            hm.put(parentComp, hm.getOrDefault(parentComp, 0) + 1);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.parent[i] == i) {
                int size = dsu.size[i];
                int edgesInComp = hm.getOrDefault(i, 0);
                int edgesReq = size * (size - 1) / 2;

                if (edgesInComp == edgesReq) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
