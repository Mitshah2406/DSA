import java.util.*;


class DisjointSet{
    public int rank[];
    public int parent[];
    
    public DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];
        
        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }
    }
    
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
    
    public boolean union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        
        if(parX==parY){
            return false; // means they are already connected if we connect then here then will result in cycle
        }
        
        if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }else if(rank[parY]>rank[parX]){
            parent[parX] = parY;
        }else{
            parent[parY] = parX;
            parX++;
        }
        
        return true;
    }
}

class Pair implements Comparable<Pair>{
    int v;
    int wt;
    public Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }

    public int compareTo(Pair p){
        return this.wt - p.wt;
    }
}

public class Solution {

	public static int minimumSpanningTreeKruskal(ArrayList<ArrayList<Integer>> edges, int n) {
		DisjointSet d = new DisjointSet(n);

 		Collections.sort(edges, (a,b)->a.get(2)-b.get(2));
		int ans = 0;
		for(int i=0;i<n;i++){
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			int w = edges.get(i).get(2);
			if(d.union(u,v)){
				ans+=w;
			}
		}

		return ans;
	}

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
		PriorityQueue<Pair> pq = new PriorityQueue<>();

        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        pq.add(new Pair(0, 0));
        int sum=0;
        while(!pq.isEmpty()){
            Pair rem = pq.remove();

            ArrayList<Pair> nbrs = adj.get(rem.v);
            if(ans[rem.v]!=Integer.MAX_VALUE) continue;

            ans[rem.v] = rem.wt;
            sum+=rem.wt;

            for(Pair p: nbrs){
                if(ans[p.v]!=Integer.MAX_VALUE) continue;

                pq.add(new Pair(p.v, p.wt));
            }
        }
       
        return sum;
	}
}
