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

    public void unionByRank(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX == parY)
            return;

        if (rank[parX] > rank[parY]) {
            parent[parY] = parX;
        } else if (rank[parY] > rank[parX]) {
            parent[parX] = parY;
        } else {
            parent[parY] = parX;
            rank[parX]++;
        }
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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    ds.unionByRank(i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(i==ds.parent[i]){
                ans++;
            }
        }

        return ans;
    }
}