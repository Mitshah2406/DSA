//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int ans = -1;
        for(int i=0;i<n;i++){
            int zeroCount=0;
            
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) zeroCount++;
            }
            if(zeroCount==n){
                ans = i;
                int oneCount=0;
                for(int k=0;k<n;k++){
                    oneCount+=mat[k][i];
                }
                if(oneCount<n-1){
                    ans = -1;
                }
            }
            
        }
        
        return ans;
    }
}