/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // brute with space
    // public Node connect(Node root) {
    // if(root==null){
    // return root;
    // }

    // Queue<Node> q = new LinkedList();
    // q.add(root);

    // while(q.size()!=0){
    // int n = q.size();
    // Node prev = null;
    // for(int i=0;i<n;i++){
    // Node rem = q.poll();
    // if(prev!=null){
    // prev.next = rem;
    // }
    // prev = rem;
    // if(rem.left!=null){
    // q.add(rem.left);
    // }
    // if(rem.right!=null){
    // q.add(rem.right);
    // }
    // }
    // }
    // return root;
    // }

    public Node connect(Node root) {
        // keep a curr and next ptr
        Node curr = root;
        Node next = null; // at root's left node
        if (root != null)
            next = root.left;

        while (curr != null && next != null) {
            curr.left.next = curr.right; // connect the direct children first

            if (curr.next != null) { // then connect indirect children one subtree's right to other subtree's left
                curr.right.next = curr.next.left;
            }
            curr = curr.next; // move curr to right i.e next in this case
            if (curr == null) { // if curr becomes null that is we processed all nodes then move curr to
                                // leftmost node of next level and next ptr to left of curr
                curr = next;
                next = curr.left;
            }

            // repeat
        }

        return root;
    }
}