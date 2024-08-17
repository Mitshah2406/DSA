class Solution {
    private int[] prefixSum(int arr[], int n) {
        int p[] = new int[n];
        p[0] = arr[0];
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + arr[i];
        }
        return p;
    }

    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0,1);
        int n = arr.length;
        int pSum[] = prefixSum(arr, n);
        int validStPts = 0;
        for (int e = 0; e < n; e++) {
            int search = pSum[e] - k;
            validStPts = validStPts + (hm.getOrDefault(search, 0));
            hm.put(pSum[e], hm.getOrDefault(pSum[e], 0) + 1);
        }
        return validStPts;
    }
}