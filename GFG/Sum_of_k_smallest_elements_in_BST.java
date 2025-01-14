//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    Node(int key){
        this.data = key;
        this.left = this.right = null;
    }
}
*/

class Tree {
    static int idx = 0;
    static int sum = 0;
    public void inorder(Node root, int k){
        if(root==null){
            return;
        }

        inorder(root.left, k);
        idx++;
        if(idx<=k){
            sum+=root.data;
        }
        inorder(root.right,k);
    }
    int sum(Node root, int k) { 
        idx=0;
        sum=0;
        inorder(root,k);
        return sum;
    } 
}