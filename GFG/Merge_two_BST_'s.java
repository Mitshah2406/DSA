// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public ArrayList<Integer> mergeArr(ArrayList<Integer> a, ArrayList<Integer> b){
        int n = a.size();
        int m = b.size();
        int i = 0; // ptr for a
        int j = 0; // ptr for b
        ArrayList<Integer> arr = new ArrayList();
        while(i<n && j<m){
            if(a.get(i)>b.get(j)){
                arr.add(b.get(j));
                j++;
            }else{
                arr.add(a.get(i));
                i++;
            }
        }
        
        while(i<n){
            arr.add(a.get(i));
            i++;
        }
        while(j<m){
            arr.add(b.get(j));
            j++;
        }
        
        return arr;
    }
    public void inorder(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList();
        ArrayList<Integer> arr2 = new ArrayList();
        
        inorder(root1, arr1);
        inorder(root2, arr2);
        
        return mergeArr(arr1,arr2);
    }
}
