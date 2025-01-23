// User function Template for Java
class DisjointSet{
    int par[];
    int rank[];
    
    public DisjointSet(int n){
        par = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
    }
    public boolean union(int a, int b){
        int parX = find(a);
        int parY = find(b);
        
        if(parX==parY){
            return false;
        }
        
        if(rank[parX]> rank[parY]){
            par[parY] = parX;
        }else if(rank[parY]> rank[parX]){
            par[parX] = parY;
        }else{
            par[parX] = parY;
            rank[parY]++;
        }
        
        return true;
    }
    
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        int t = find(par[x]);
        par[x] = t;
        return t;
    }
    
    public int count(){
        int cnt=0;
        for(int i=0;i<par.length;i++){
            if(par[i]==i){
                cnt++;
            }
        }
        return cnt;
    }
}
class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.w-e.w;
        }
    }
class Solution {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       DisjointSet ds = new DisjointSet(V);
       int ans = 0;
       ArrayList<Edge> edges = new ArrayList();
       for(int i=0;i<V;i++){
           int u = i;
           for(int[] vc : adj.get(i)){
               int v = vc[0];
               int wt = vc[1];
               
              edges.add(new Edge(u,v,wt));
           }
       }
       
       Collections.sort(edges);
       int n = edges.size();
       for(int i=0;i<n;i++){
           Edge e = edges.get(i);
           if(ds.union(e.u,e.v)){
               ans+=e.w;
           }
       }
       return ans;
    }
    
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       int ans = 0;
       ArrayList<Edge> edges = new ArrayList();
       for(int i=0;i<V;i++){
           int u = i;
           for(int[] vc : adj.get(i)){
               int v = vc[0];
               int wt = vc[1];
               
              edges.add(new Edge(u,v,wt));
           }
       }
       
       Collections.sort(edges);
       
    }
}