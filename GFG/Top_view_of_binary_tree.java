class Pair {
    Node n;
    int level;
    public Pair(Node n, int l){
        this.n = n;
        this.level =l;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> arr = new ArrayList();
        TreeMap<Integer, Integer> hm = new TreeMap();
        
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        if(root==null) return arr;
        while(q.size()>0){
            Pair p = q.remove();
            
            if(!hm.containsKey(p.level)){
                hm.put(p.level, p.n.data);
            }  
            Node curr = p.n;
            if(curr.left!=null){
                q.add(new Pair(curr.left, p.level-1));
            }
             if(curr.right!=null){
                q.add(new Pair(curr.right, p.level+1));
            }
        
        }
        
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            arr.add(e.getValue());
        }
        return arr;
    }
}