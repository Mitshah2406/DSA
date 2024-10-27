// User function Template for Java

class Solution {
    public void nQueen(int mat[][],ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> placement, int i, int n){
        if(i==n){
            ans.add(new ArrayList<Integer>(placement));
            return;
        }
        
        for(int j=0;j<n;j++){
            if(check(mat, i, j, n)){
                placement.add(j+1);
                mat[i][j]=1;
                nQueen(mat,ans,placement, i+1,n);     
                mat[i][j]=0;
                placement.remove(placement.size()-1);
            }
        }
    }
    
    public boolean check(int mat[][], int row, int col,int n){
        //check same col
        
        for(int i=0;i<row;i++){
            if(mat[i][col]==1){
                return false;
            }
        }
        
        
        // check upper left diag 
        int r = row;
        int c = col;
        
        while(r>=0 && c>=0){
            if(mat[r][c]==1){
                return false;
            }
            r--;
            c--;
        }
        
        // check upper right diag
        r = row;
        c = col;
        
        while(r>=0 && c<n){
            if(mat[r][c]==1){
                return false;
            }
            r--;
            c++;
        }
        
        
        return true;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        int mat[][] = new int[n][n];
        nQueen(mat, ans,new ArrayList<Integer>(),0, n);
        return ans;
    }
}