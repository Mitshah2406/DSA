class Solution {
    public long pickGifts(int[] gifts, int k) {

        // just add all elems to max heap nad take the sum
        int n = gifts.length;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts){
            pq.add(i);
            sum+=i;
        }

        // extract the max for k second i.e remove from pq
        // sum-extracted
        //sum+extracted
        // pq.add(extracted)

        // return sum
        while(k!=0){
            int rem = pq.remove();
            sum-=rem;
            int root = (int) Math.floor(Math.sqrt(rem));
            sum+=root;
            pq.add(root);
            k--;
        }
        return sum;
        
    }
}