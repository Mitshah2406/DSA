class Pair{
    int id;
    int max;
    int min;
    boolean valid;
    public Pair(int i, int max ,int min, boolean v){
        this.id = i;
        this.max = max;
        this.min = min;
        this.valid = v;
    }
}
class Solution {
    private Pair inorder(Node root){
        if ( root == null ) return new Pair(-1, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
      
        Pair l = inorder(root.left);
        if(l.valid==false) return l;
        
        Pair r = inorder(root.right);
        if(r.valid==false) return r;
        
        
        if(l.max<root.data &&  root.data<r.min){
            return new Pair(root.data, Math.max(r.max, root.data), Math.min(l.min, root.data),  true);
        }
        
   
        return new Pair(-1, Integer.MAX_VALUE, Integer.MIN_VALUE, false);
    }
    boolean isBST(Node root) {
    //   List<Integer> arr = new ArrayList();
       
     return  inorder(root).valid;
   
    }
}