/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // private void find(Node root, List<List<Integer>> res, List<Integer> curr){
    //     if(root==null) return;
    //     curr.add(root.val);
    //     for(Node n : root.children){
    //         find(n, res, curr);
    //     }
    // }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int n = q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node rem = q.poll();
                arr.add(rem.val);
                for(Node no: rem.children){
                    q.add(no);
                }
            }
            res.add(arr);
        }
        return res;
    }
}