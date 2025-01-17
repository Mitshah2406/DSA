/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode right;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.val+"_");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static int i=0;
    // public TreeNode build(String arr[]){
    //     if(i>=arr.length){
    //         return null;
    //     }
    //     if(arr[i].equals("N")){
    //         i++;
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
    //     root.left = build(arr);
    //     root.right = build(arr);

    //     return root;
    // }

    public TreeNode build(String arr[], int st, int end){

        if(st>end){ // when st cross end return null
            return null;
        }
        int idx = st;

        // exploit bst property just find right part in arr 
        for(idx=st;idx<=end;idx++){
            if(Integer.parseInt(arr[idx])>Integer.parseInt(arr[st])){
                break;
            }
        }
        // st is root as it is preorder
        TreeNode root = new TreeNode(Integer.parseInt(arr[st]));
        // values before right part idx are on left
        root.left = build(arr,st+1,idx-1);
        // values from idx to end are right
        root.right = build(arr,idx,end);
        return root;
    }
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        i=0;
        String arr[] = data.split("_");
        int n = arr.length;
        return build(arr, 0, n-1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;