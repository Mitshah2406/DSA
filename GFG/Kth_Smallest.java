class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        
        /*
        Using Pq
        Time - O(NLogN) + O(KLogN)
        Space - O(N) stores all element
        */
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int n = arr.length;
        // for(int i=0;i<n;i++){
        //     pq.add(arr[i]);
        // }
        
        // int i = 0;
        // int num = 0;
        // while(i!=k){
        //     num = pq.poll();
        //     i++;
        // }
        
        // return num;
        
        
        
        /*
        Optimal Solution
        Time - O(NLogN)
        Space - O(K+1) stores a maximum of (k+1) elements at any time
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
