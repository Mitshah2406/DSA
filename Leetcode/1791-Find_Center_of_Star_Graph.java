class Solution {
    public int findCenter(int[][] edges) {

        // Brute force - O(E) time, O(V) space
        // int e = edges.length;
        // int v = e+2;
        // int count[] = new int[v];

        // for(int edge[] : edges){
        // int x = edge[0];
        // int y = edge[1];
        // count[x]++;
        // count[y]++;

        // if(count[x]==e) return x;
        // if(count[y]==e) return y;
        // }
        // return -1;

        // Optimal

        // Here it is given as edges[][] will represent a valid star graph means there
        // would be a
        // common vertex in every edge coz (V = Edges.length+1) i.e V = e+2 for 1 based
        // indexing

        // so if edges are 3 then graph has 4 nodes so all three edges would have one
        // vertice common so as to form a valid star graph

        int u1 = edges[0][0];
        int v1 = edges[0][1];
        int u2 = edges[1][0];
        int v2 = edges[1][1];

        if (u1 == u2 || u1 == v2) {
            return u1;
        } else {
            return v1;
        }
    }
}