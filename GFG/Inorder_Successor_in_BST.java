// User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
//{ Driver Code Starts
// Initial Template for Java


class Solution {
    
    // non optimal approach with space usage
    // static int idx = -1;
    // public void inorder(Node root, Node x, ArrayList<Integer> arr){
    //     if(root==null){
    //         return;
    //     }
        
    //     inorder(root.left,x,arr);
    //     arr.add(root.data);
    //     if(root==x){
    //         idx = arr.size()-1;
    //     }
    //     inorder(root.right,x,arr);
    // }
    // public int inorderSuccessor(Node root, Node x) {
    //     idx=-1;
        
    //     ArrayList<Integer> arr = new ArrayList();
        
    //     inorder(root,x,arr);
    //     int n = arr.size();
    //     if(idx==n-1){
    //         return -1;
    //     }else{
    //         return arr.get(idx+1);
    //     }
    // }
    
    
    // optimal
    // static int count = 0;
    // static int ele = -1;

    // static boolean found = false;
    // public void inorder(Node root, Node x){
    //     //  System.out.println("Starting call with count"+count +" and ele as"+ele);
    //     if(root==null || count==1){
    //         //  System.out.println("Pruned");
    //         return;
    //     }
        
    //     inorder(root.left,x);
        

    //     if(root==x){
    //         found=true;
    //     }else{
    //         if(found && count<1){
    //             // System.out.println("Found ele"+ele);
    //             count++;
    //             ele = root.data;
    //             return;
    //         }
    //     }
    //     inorder(root.right,x);
    // }
    // public int inorderSuccessor(Node root, Node x) {
    //     ele=-1;
    //     count=0;
    //     found =false;
    //     inorder(root,x);
       
    //     return ele;
    // }
    
    
    // more optimal
    
   // Optimal Approach
    // TC: O(H), SC: O(1)
    public int inorderSuccessor(Node root, Node x) {
    Node temp = null;

    // Traverse the BST to find the node `x`
    while (root != null && root.data != x.data) {
        if (root.data > x.data) {
            temp = root; // Store the potential successor
            root = root.left;
        } else {
            root = root.right;
        }
    }

    // If `x` is not found in the BST, return -1
    if (root == null) {
        return -1;
    }

    // If `x` has a right subtree, find the leftmost node in that subtree
    if (root.right != null) {
        Node p1 = root.right;
        while (p1.left != null) {
            p1 = p1.left;
        }
        return p1.data; // Return the leftmost node in the right subtree
    }

    // If no right subtree, return the last stored potential successor
    return (temp != null) ? temp.data : -1;
}

}