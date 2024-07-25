class Solution {
    public static Node findRoots(int arr[], int low, int high, HashMap<Integer, Node> hm){
        
        int mid = low+(high-low)/2;
        // if(hm.containsKey(mid)){
        //     return null;
        // }
        if(low>high) return null;
        Node n = new Node(arr[mid]);
        hm.put(mid, n);
        
        if(low==high) return n;
        Node x = findRoots(arr, low, mid-1, hm);
        Node y = findRoots(arr, mid+1, high, hm);
       if(n!=x){
            n.left = x;
       }
       if(n!=y){
           n.right = y;
       }
        return n;
    }
    
    public Node sortedArrayToBST(int[] nums) {
        if(nums.length==1) return new Node(nums[0]);
        
        HashMap<Integer, Node> hm = new HashMap();
        Node root = findRoots(nums, 0, nums.length-1, hm);
        return root;
        
        
    }
}