class DisjointSet{
    int par[];
    int rank[];
    int size;
    int indexing = 0;
    public DisjointSet(int n){
        this.size = n;
        par = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
    }

    public boolean union(int x, int y){
        int pX = find(x);
        int pY = find(y);
        if(pX==pY) return false;

        if(rank[pX]>rank[pY]){
            par[pY] = pX;
        }else if(rank[pX]<rank[pY]){
            par[pX] = pY;
        }else {
            par[pX] = pY;
            rank[pY]++;
        }
        return true;
    }

    public int find(int x){
        if(par[x] == x) return x;

        int t = find(par[x]);
        par[x] = t;
        return t;
    }

    public int countComponents(){
        int cnt = 0;
        for(int i=indexing;i<size;i++){
            if(par[i]==i) cnt++;
        }
        return cnt;
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet dsu = new DisjointSet(n);
        dsu.indexing = 0;
        int freeEdges = 0;
        for(int e[] : connections){
            if(!dsu.union(e[0],e[1])){
                freeEdges++;
            }
        }

        int noOfComponents = dsu.countComponents();

        if(noOfComponents==1){
            return 0;
        }else{
            if(freeEdges>=noOfComponents-1){
                return noOfComponents-1;
            }else{
                return -1;
            }
        }

    }
}