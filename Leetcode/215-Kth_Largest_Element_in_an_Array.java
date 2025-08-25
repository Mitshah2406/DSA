class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        /**
        Time - O(NLogN) + O(KLogN)
        Space - O(N) stores N elements at max
         */
        // int n = nums.length;

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for(int ele : nums){
        //     pq.add(ele);
        // }
        // int num = -1;
        // for(int i=0;i<k;i++){
        //     num = pq.poll();
        // }
        // return num;


        /**
        Time - O(NLogN)
        Space - O(K+1) stores (K+1) elements at max
         */
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
           
        }
        return pq.peek();
    }
}