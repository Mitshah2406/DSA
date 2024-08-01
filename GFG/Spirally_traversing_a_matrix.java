//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int rSteps = mat.length-1;
        int cSteps = mat[0].length-1;
        ArrayList<Integer> arr= new ArrayList();
        int i = 0;
        int j = 0;
       
        while(rSteps>=1 && cSteps>=1){
            
            for(int k =0;k<cSteps;k++){
                arr.add(mat[i][j]);
                j++;
            }
            
            for(int k=0;k<rSteps;k++){
                arr.add(mat[i][j]);
                i++;
            }
            
            for(int k=0;k<cSteps;k++){
                arr.add(mat[i][j]);
                j--;
            }
            
            for(int k=0;k<rSteps;k++){
                arr.add(mat[i][j]);
                i--;
            }
            
            i++;
            j++;
            rSteps-=2;
            cSteps-=2;
        }
        
        if(rSteps==0){
            for(int k=0;k<cSteps+1;k++){
                arr.add(mat[i][j]);
                j++;
            }
        }else if(cSteps==0){
            for(int k=0;k<rSteps+1;k++){
                arr.add(mat[i][j]);
                i++;
            }
        }
       return arr;
    }
}
