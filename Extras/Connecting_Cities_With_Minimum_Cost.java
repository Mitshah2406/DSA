import java.util.* ;
import java.io.*; 
    class DisjointSet{
        public int rank[];
        public int parent[];
        public int n;
        public DisjointSet(int n){
            this.n=n;
            this.rank = new int[n];
            this.parent = new int[n];

            for(int i=0;i<n;i++){
                rank[i] = 1;
                parent[i] = i;
            }
        }

        private int find(int x){
            if(x==parent[x]){
                return x;
            }

            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }

        public boolean union(int x, int y){
            int ux = find(x);
            int uy = find(y);
            if (ux==uy) return false;
            if(rank[ux]>rank[uy]){
                parent[uy] = ux;
            }else if(rank[uy]>rank[ux]){
                parent[ux] = uy;
            }else{
                parent[ux] = uy;
                rank[uy]++;
            }

            return true;
        }

        public boolean check(){
            int distinctSets = 0;
            for(int i=1;i<this.n;i++){
                if(parent[i]==i){
                    distinctSets++;
                }
            }
            return distinctSets==1;
        }
    }
public class Solution {
 
    public static int getMinimumCost(int n, int m, int[][] connections) {
        Arrays.sort(connections, (a,b)-> a[2]-b[2]);
        int cost = 0;
        DisjointSet dsu = new DisjointSet(n+1);
        for(int i=0;i<m;i++){
            int edge[] = connections[i];
            boolean isNotCycle = dsu.union(edge[0], edge[1]);

            if(isNotCycle){
                cost+=edge[2];
            }
        }
        boolean allCitiesCheck = dsu.check();
        if(!allCitiesCheck){
            return -1;
        }
        return cost;
    }
    
}
