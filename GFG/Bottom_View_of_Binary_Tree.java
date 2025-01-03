//User function Template for Java


class Solution
{
    class Pair{
        Node n;
        int vL;
        public Pair(Node n, int vL){
            this.n=n;
            this.vL=vL;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        HashMap<Integer, Integer> hm = new HashMap();
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(q.size()!=0){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                Pair rem = q.poll();
                Node n = rem.n;
                int vL = rem.vL;
                
                hm.put(vL, n.data);
                max = Math.max(vL, max);
                min = Math.min(vL, min);
                if(n.left!=null){
                    q.add(new Pair(n.left, vL-1));
                }
                if(n.right!=null){
                    q.add(new Pair(n.right, vL+1));
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList();
        for(int i=min;i<=max;i++){
            arr.add(hm.get(i));
        }
        
        return arr;
    }
}