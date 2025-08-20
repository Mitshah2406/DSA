class Solution {
    /*
    Time - O(N^2), Space - O(1)
    */
    static void brute(int arr[], int n, List<Integer> ans, int k){
        for(int i=0;i<n;i++){
            int neg = 0;
            for(int j=i;j<n;j++){
                if(arr[j]<0 && neg==0){
                    neg = arr[j];
                }
                if(j-i+1==k){
                    ans.add(neg);
                    break;
                }
            }
        }
    }
    
    /*
    Time - O(N), Space - O(n - k + 1) as we have n-k+1 windows
    
    Used sliding windows with queue for storing negatives in FIFO order
    as it saves us time while sliding and gets us the first negative too
    */
    static void optimal(int arr[], int n, List<Integer> ans, int k){
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }
        
        if(q.size()==0){
            ans.add(0);
        }else{
            ans.add(arr[q.peek()]);
        }
        
        
        for(int i=k;i<n;i++){
            // prune last window ele
            while(q.peek()!=null && q.peek()<=(i-k)){ 
                // as we are adding all negs, not just the first,
                // remove them through loop
                q.poll();
            }
            // add new window ele
            if(arr[i]<0){
                q.add(i);
            }
            // add to ans
            if(q.size()==0){
                ans.add(0);
            }else{
                ans.add(arr[q.peek()]);
            }
        }
        
    }
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        // brute(arr, n, ans, k);
        optimal(arr, n, ans, k);
        return ans;
    }
}
