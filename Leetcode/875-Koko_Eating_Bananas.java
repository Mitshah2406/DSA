class Solution {
    private long eat(int arr[], int n, int eatRate) {
        // just simulate eating
        long totalHrs = 0;
        for (int bananas : arr) {
            totalHrs += (long) Math.ceil((double)bananas / (double)eatRate); // ceil taken because if for eg it take 1.5 hrs, the 30 min cannot be transferred to next pile, so waste it
        }
        return totalHrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1; // no point of eating 0 bananas/hr
        int high = -1; // max bananas in a piles, no point going further
        for(int i: piles){
            high = Math.max(i,high);
        }

        while(low<=high){
            int mid = low + (high-low)/2;

            if(eat(piles, n, mid)<=h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}