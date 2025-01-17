/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.

    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N_");
            return;
        }
        sb.append(root.val);
        sb.append("_");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static int i=0;
    public TreeNode build(String[] arr){
        if(i>=arr.length){
            return null;
        }
        if(arr[i].equals("N")){
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
    public TreeNode deserialize(String data) {
        i=0;
        
        String arr[] = data.split("_");
        return build(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));