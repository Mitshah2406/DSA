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
    private void pTraverse(Node root, List<Integer> arr){
        if(root==null){
            return;
        }
        List<Node> children = root.children;
        for(Node c: children){
            pTraverse(c, arr);
        }
        arr.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> arr= new ArrayList();
        pTraverse(root,arr);
        return arr;
    }
}