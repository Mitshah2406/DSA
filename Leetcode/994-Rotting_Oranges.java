class Solution {
    /*
     * Mutli Source BFS is needed as we need to check from all rotten oranges in all
     * 4 directions simultaneously how many time needed to rot
     * 
     * Time - O(n*m){Initial Src Finding} + O(m*n){BFS} = O(2(m*n)) ~ O(m*n)
     * Space - O(m*n){Queue Space} + O(m*n) {Visited Arr space} = O(2(m*n)) ~ O(m*n)
     */
    class Pair{
        int i;
        int j;
        int t;
        public Pair(int i, int j, int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public boolean isInBounds(int i, int j, int m, int n){
        return (i>=0 && j>=0 && j<m && i<n);
    }
    public int orangesRotting(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        Queue<Pair> q = new LinkedList();
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        int dirs[][] = {
            {0,1}, {1,0},{-1,0},{0,-1}
        };
        int max = 0;
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int u = rem.i;
            int v = rem.j;
            int t = rem.t;
            max = Math.max(t,max);

            for(int i=0;i<4;i++){
                int nr = u + dirs[i][0];
                int nc = v + dirs[i][1];

                if(isInBounds(nr,nc,m,n) && grid[nr][nc]==1){
                    count--;
                    q.add(new Pair(nr,nc, t+1));
                    grid[nr][nc]=2;
                }
            }
        }
        return count==0 ? max : -1;
    }
}