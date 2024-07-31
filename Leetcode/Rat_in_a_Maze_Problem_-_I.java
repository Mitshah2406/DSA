//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends




class Solution {
    public static void solve(int i, int j, int mat[][], int vis[][], ArrayList<String>ans, String path, int n){
       //bc
        if(i==n-1 && j==n-1){
            ans.add(path);
            return;
        }
        //downwards
        //mit
        if(i+1<n && vis[i+1][j]==0 && mat[i+1][j]==1){
            vis[i][j] = 1;
            solve(i+1,j,mat,vis,ans, path+"D",n);
            vis[i][j] = 0;
        }
        
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
       if(mat[0][0]==1) solve(0,0,mat, vis, ans, "",n);
       // atharva bhadwa
       return ans;
    }
}

// DLRU