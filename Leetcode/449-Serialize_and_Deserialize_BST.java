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
    private void serializeHelper(TreeNode root, StringBuilder s){
        if(root==null){
            s.append("N ");
            return;
        }
        s.append(root.val +" ");
        serializeHelper(root.left, s);
        serializeHelper(root.right, s);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serializeHelper(root, s);
        return s.toString();
    }
    int i;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String ch[] = data.split(" ");
        i = 0;
        TreeNode root = deserializeHelper(ch);
        return root;
    }

    private TreeNode deserializeHelper(String[] ch){
        if(ch[i].equals("N")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ch[i]));
        i++;
        root.left = deserializeHelper(ch);
        root.right = deserializeHelper(ch);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;