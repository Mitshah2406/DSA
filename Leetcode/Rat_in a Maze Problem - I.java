        //left
        
        if(j-1>=0 && vis[i][j-1]==0 && mat[i][j-1]==1){
            vis[i][j] = 1;
            solve(i,j-1,mat,vis,ans, path+"L",n);
            vis[i][j] = 0;
        }
        
        //right
        
        if(j+1<n && vis[i][j+1]==0 && mat[i][j+1]==1){
            vis[i][j] = 1;
            solve(i,j+1,mat,vis,ans, path+"R",n);
            vis[i][j] = 0;
        }
        
        //upwards
        
        if(i-1>=0 && vis[i-1][j]==0 && mat[i-1][j]==1){
            vis[i][j] = 1;
            solve(i-1,j,mat,vis,ans, path+"U",n);
            vis[i][j] = 0;
        }
    }
    
    
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
       int vis[][] = new int[n][n];
    //   for(int i=0;i<n;i++){
    //       Arrays.fill(mat[i],0);
    //   }
       ArrayList<String> ans = new ArrayList();