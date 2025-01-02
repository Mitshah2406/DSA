/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        if(root==null) 
            return new ArrayList<Integer>();
            
        Stack<Integer> st = new Stack();
        Queue<Node> q = new LinkedList();
        q.add(root);
        
        while(q.size()!=0){
            
            Node rem = q.poll();
            st.push(rem.data);
            if(rem.right!=null) 
                q.add(rem.right);
            if(rem.left!=null) 
                q.add(rem.left);
            
        }
        ArrayList<Integer> arr = new ArrayList();
        while(!st.isEmpty()){
            arr.add(st.pop());
        }
        return arr;
    }
}