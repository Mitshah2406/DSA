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
    public Node connect(Node root) {
        // Brute with space
        // if (root == null)
        //     return root;
        // Queue<Node> q = new LinkedList();
        // q.add(root);

        // while (q.size() != 0) {
        //     int n = q.size();
        //     Node prev = null;
        //     for (int i = 0; i < n; i++) {
        //         Node rem = q.poll();
        //         if (prev != null) {
        //             prev.next = rem;
        //         }
        //         prev = rem;
        //         if (rem.left != null)
        //             q.add(rem.left);
        //         if (rem.right != null)
        //             q.add(rem.right);
        //     }
        // }
        // return root;



        // optimal tc - o(n), sc constant
        // take a extra dummy node on second level and go on connecting
        Node head = root;

        while(head!=null){
            Node dummy = new Node(-1);
            Node temp = dummy;

            while(head!=null){
                if(head.left!=null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null){
                    temp.next = head.right;
                    temp = temp.next;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }
}