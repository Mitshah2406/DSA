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

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        int ans = find(parent[x]);
        parent[x] = ans;
        return ans;
    }

    public boolean unionByRank(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (parX == parY) {
            return false;
        }
        if (rank[parX] > rank[parY]) {
            parent[parY] = parX;
        } else if (rank[parX] < rank[parY]) {
            parent[parX] = parY;
        } else {
            parent[parY] = parX;
            rank[parX]++;
        }
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n+1);
        DisjointSet bob = new DisjointSet(n+1);
        // A --> Alice, B --> Bob
        Arrays.sort(edges, (a,b) -> b[0]-a[0]);
        int edgeRemoveCount = 0;
        int nodesConsideredA = 1;
        int nodesConsideredB = 1;
        for(int edge[]: edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(type==3){
                boolean mergeA = alice.unionByRank(u,v); // for alice
                boolean mergeB = bob.unionByRank(u,v); // for bob

                if(!mergeA && !mergeB){
                    edgeRemoveCount++;
                }
                if(mergeA){
                    nodesConsideredA++;
                }
                if(mergeB){
                    nodesConsideredB++;
                }
            }else if(type==2){
                // Bob
                boolean mergeB = bob.unionByRank(u,v); // for bob

                if(!mergeB){
                   edgeRemoveCount++;
                }else{
                    nodesConsideredB++;
                }
            }else{
                // Alice
                boolean mergeA = alice.unionByRank(u,v); // for alice

                if(!mergeA){
                    edgeRemoveCount++;
                }else{
                    nodesConsideredA++;
                }
            }
        }
        if(nodesConsideredA!=n || nodesConsideredB!=n){
            return -1;
        }
        return edgeRemoveCount;
    }
}