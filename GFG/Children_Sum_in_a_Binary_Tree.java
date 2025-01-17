//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static boolean check(Node root){
        if(root==null){
            return true;
        }
        int sum = 0;
        boolean isLeaf = true;
        if(root.left!=null){
            sum+=root.left.data;
            isLeaf = false;
        }
        if(root.right!=null){
            sum+=root.right.data;
            isLeaf = false;
        }
        
        if(sum==root.data || isLeaf){
            return check(root.left) && check(root.right);
        }else{
            return false;
        }
    }
    public static int isSumProperty(Node root)
    {
        return check(root)==true?1:0;
        
    }
}