//User function Template for Java
class DisjointSet{
    int par[];
    int rank[];
    int size;
    int indexing = 0;
    public DisjointSet(int n){
        par = new int[n];
        rank = new int[n];
        this.size = n;
        
        for(int i=0;i<n;i++){
            par[i] = -1; // initially there is no component
            rank[i] = 1;
        }
    }
    
    public boolean union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        
        if(parX==parY){
            return false;
        }
        if(rank[parX]>rank[parY]){
            par[parY] = parX;
        }else if(rank[parY]>rank[parX]){
            par[parX] = parY;
        }else{
            par[parX] = parY;
            rank[parY]++;
        }
        
        return true;
    }
    public int find(int x){
        if(par[x]==x) return x;
        int t = find(par[x]);
        return par[x] = t;
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
    public int convertTo1D(int row, int totalCol, int col){
        return row*totalCol + col;
    }
    public boolean isInBound(int i, int j, int n, int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> arr = new ArrayList();
        int grid[][] = new int[rows][cols];
        int ans = 0;
        DisjointSet dsu = new DisjointSet(rows*cols);
        int dirs[][] = {
            {1,0},{0,1},{-1,0},{0,-1}
        };
        for(int q[] : operators){
            int r = q[0];
            int c = q[1];
            if(grid[r][c]==1){
                arr.add(ans);
                continue;
            }
            int converted = convertTo1D(r,cols,c);
            grid[r][c] = 1;
            dsu.par[converted] = converted;
            ans+=1;
            boolean recount = false;
            for(int i=0;i<4;i++){
                int nR = r + dirs[i][0];
                int nC = c + dirs[i][1];
                if(isInBound(nR,nC, rows,cols) && grid[nR][nC]==1){
                    int convertedNew = convertTo1D(nR,cols,nC);
                    boolean res = dsu.union(converted, convertedNew);
                    if(res) ans--;
                }
            }
            
            arr.add(ans);
        }
        
        return arr;
    }
    
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

