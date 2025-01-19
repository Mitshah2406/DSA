//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    // {min, max, size}

    static int[] postorder(Node root){
        if(root== null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        
        int[] x = postorder(root.left);
        int[] y = postorder(root.right);
        
        if(x[1]<root.data && y[0]>root.data){
            int nodes = x[2]+y[2]+1;
            // if satisi=fies then send left ka min, and right ka max and nodes is left+right+root la 1
            return new int[]{
                Math.min(root.data, x[0]),
                Math.max(root.data, y[1]),
                nodes
            };
            
        }
        // if not min me send intmin so that no one satisifies, and send left/right ka max subtree size
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(x[2],y[2])};
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
       return postorder(root)[2];
    }
    
}