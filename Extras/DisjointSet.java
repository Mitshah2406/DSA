// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class DisjointSet {
    int[] rank, parent,  size;
    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }
    
    public int findUltimateParent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }
    
    public void unionByRank(int u, int v){
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if(pu==pv) return;
        
        if(rank[pu]< rank[pv]){
            parent[pu] = pv;
        }else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }else{
             parent[pv] = pu;
             rank[pu]++;
        }
    }
    public void unionBySize(int u, int v){
        int pu = findUltimateParent(u);
        int pv = findUltimateParent(v);
        
        if(pu==pv) return;
        
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] +=size[pu];
        }else{
            parent[pv] = pu;
             size[pu] +=size[pv];
        }
    }
} 
    
public class Main{   
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        if(ds.findUltimateParent(3)==ds.findUltimateParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }
        ds.unionBySize(3,7);
         if(ds.findUltimateParent(3)==ds.findUltimateParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }
        
    
    }
}