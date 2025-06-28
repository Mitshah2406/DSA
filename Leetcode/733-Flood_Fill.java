class Solution {
    /*
        Simple BFS Solution just keep changing the colors which match, and use that as visited check too..
        Time = O(n*m) might visit every cell once
        Space = O(n*m) cells
     */
    public boolean isInBound(int i, int j, int n, int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if(image[sr][sc]==color){
            return image;
        }

        Queue<int[]> q = new LinkedList();
        int initColor = image[sr][sc];
        image[sr][sc] = color;
        q.add(new int[]{sr,sc});
        int dirs[][] = {
            {1,0},{0,1},{0,-1},{-1,0}
        };
        while(!q.isEmpty()){
            int rem[] = q.poll();

            for(int i=0;i<4;i++){
                int nr = rem[0] + dirs[i][0];
                int nc = rem[1] + dirs[i][1];

                if(isInBound(nr,nc,n,m) && image[nr][nc]==initColor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
}