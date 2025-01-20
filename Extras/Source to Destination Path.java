import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        // construction of adj list
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // src & dest
        
        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean ans = false;
        

        
        Queue<Integer> q = new LinkedList();
        
        boolean vis[] = new boolean[V];
        q.add(src);
        vis[src] = true;
        
        while(q.size()!=0){
            int rem = q.poll();
            if(dest==rem){
               ans = true;
            }
            
            for(int nbr : adj.get(rem)){
                if(!vis[nbr]){
                    q.add(nbr);
                    vis[nbr] = true;
                }
            }
        }
        
        System.out.println(ans);
    }
}
