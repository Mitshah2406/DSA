class Solution {
    private boolean canPlace(int arr[], int dist, int m, int n) {
        int usedBuckets = 1;
        int lastBucket = 0;
        for (int i = 1; i < n; i++) {
            // System.out.println(position[i] - position[lastBucket]);
            if (Math.abs(arr[i] - arr[lastBucket]) >= dist) {
                usedBuckets++;
                lastBucket = i;
            }
        }
        return usedBuckets>=m;
    }

    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        int low = 1;
        int high = position[n - 1] - position[0];
        // int ans = -1;
        // for(int size=low;size<=high;size++){
        //     int usedBuckets = 1;
        //     int lastBucket = 0;
        //     for(int i=1;i<n;i++){
        //         System.out.println(position[i]-position[lastBucket]);
        //         if(Math.abs(position[i]-position[lastBucket])>=size){
        //             usedBuckets++;
        //             lastBucket = i;
        //         }
        //     }
        //     if(usedBuckets>=m){
        //         ans = size;
        //     }
        // }
        // return ans;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, mid, m, n)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}