class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[] {};
        }
        if (n == 1) {
            return new int[] { 1 };
        }
        int rank[] = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = arr[i];
        }

        Arrays.sort(arr);

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int r = 2;
        hm.put(arr[0], 1);

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                hm.put(arr[i], r - 1);
                continue;
            }
            hm.put(arr[i], r++);
        }

        for (int i = 0; i < n; i++) {
            rank[i] = hm.get(rank[i]);
        }

        return rank;
    }
}