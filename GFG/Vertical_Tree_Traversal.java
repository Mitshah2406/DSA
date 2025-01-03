//User function Template for Java


class Solution
{
    static class Pair{
        Node n;
        int vL;
        public Pair(Node n, int vL){
            this.n=n;
            this.vL=vL;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList();
        
        q.add(new Pair(root, 0));
        
        while(q.size()!=0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair rem = q.poll();
                Node n = rem.n;
                int vL = rem.vL;
                
                ArrayList<Integer> temp = hm.getOrDefault(vL, new ArrayList<Integer>());
                temp.add(n.data);
                hm.put(vL, temp);
                
               
                if(n.left!=null){
                    q.add(new Pair(n.left, vL-1));
                }
                if(n.right!=null){
                    q.add(new Pair(n.right, vL+1));
                }
            }
        }
        for(int i:hm.keySet()){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        ArrayList<Integer> arr = new ArrayList();
        for(int i=min;i<=max;i++){
            arr.addAll(hm.get(i));
        }
        return arr;
    }
}