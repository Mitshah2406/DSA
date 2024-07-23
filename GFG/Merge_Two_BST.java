class Solution {
    private List<Integer> mergeSortedArr(List<Integer> f, List<Integer> s){
        int i = 0;
        int j = 0;
        int n = f.size();
        int m = s.size();
        List<Integer> res = new ArrayList();
        
        while(i< n && j<m){
            if(f.get(i)<=s.get(j)){
                res.add(f.get(i));
                i++;
            }else if(f.get(i)>s.get(j)){
                res.add(s.get(j));
                j++;
            }
        }
        
        while(i<n){
            res.add(f.get(i));
            i++;
        }
         while(j<m){
            res.add(s.get(j));
            j++;
        }
        
        return res;
    }
    private void inorder(Node root, List<Integer> arr){
        if(root==null) return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    public List<Integer> merge(Node root1, Node root2) {
        
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        
        inorder(root1, l1);
        inorder(root2, l2);
        
        return mergeSortedArr(l1,l2);
    }
}
