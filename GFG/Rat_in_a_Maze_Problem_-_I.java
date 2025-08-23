import java.util.*;
class Solution {
    // Function to find all possible paths
    private void find(int i, int j, StringBuilder sb, int n,int maze[][], ArrayList<String> ans){
        if(i==n-1 && j==n-1){
            ans.add(sb.toString());
            return;
        }
        maze[i][j] = 0;
        if(i+1<n && maze[i+1][j]==1){
            sb.append("D");
            find(i+1,j,sb,n,maze,ans);
            sb.setLength(sb.length()-1);
        }
        if(j+1<n && maze[i][j+1]==1){
            sb.append("R");
            find(i,j+1,sb,n,maze,ans);
            sb.setLength(sb.length()-1);
        }
        if(i-1>=0 && maze[i-1][j]==1){
            sb.append("U");
            find(i-1,j,sb,n,maze,ans);
            sb.setLength(sb.length()-1);
        }
        if(j-1>=0 && maze[i][j-1]==1){
            sb.append("L");
            find(i,j-1,sb,n,maze,ans);
            sb.setLength(sb.length()-1);
        }
        maze[i][j]=1;
    }
    // Backtracking Approach
    // TC: O(4 ^ (N*N)), SC: O(N^2)
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        int m = maze[0].length;
        ArrayList<String> ans = new ArrayList<>();
        
        find(0,0,new StringBuilder(),n, maze, ans);
        
        Collections.sort(ans);
        return ans;
    }
}



// Your Output:
// DDRDRR DDRURR DRDDRR
// Expected Output:
// DDRDRR DRDDRR
