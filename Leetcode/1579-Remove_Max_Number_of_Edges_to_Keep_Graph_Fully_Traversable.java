class DisjointSet{
    int parent[];
    int rank[];
    int n;
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        this.n=n;
    }

    public boolean union(int x, int y){
        int parX = find(x);
        int parY = find(y);

        if(parX==parY){
            return false;
        }

        if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }else if(rank[parY]>rank[parX]){
            parent[parX] = parY;
        }else{
            parent[parX] = parY;
            rank[parY]++;
        }
        return true;
    }

    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        int t = find(parent[x]);
        parent[x] = t;
        return t;
    }

    public int countComponents(){
        int res = 0;
        for(int i=1;i<parent.length;i++){
            if(parent[i]==i){
                res++;
            }
        }
        return res;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n+1); // DSU for alice
        DisjointSet bob = new DisjointSet(n+1); // DSU for bob
        int remEdges = 0;
        Arrays.sort(edges, (a,b)-> Integer.compare(b[0],a[0]));
        for(int i=0;i<edges.length;i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if(type==3){
                boolean rem1 = alice.union(u,v);
                boolean rem2 = bob.union(u,v);


                if(rem1==false && rem2==false){
                    remEdges++;
                }
            }else if(type==2){
                boolean rem = bob.union(u,v);
                if(rem==false){
                    remEdges++;
                }
            }else{
                boolean rem = alice.union(u,v);
                if(rem==false){
                    remEdges++;
                }
            }
        }
        if(alice.countComponents()!=1 || bob.countComponents()!=1){
            return -1;
        }
        return remEdges;
    }
}