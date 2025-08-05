class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;
        int n = fruits.length;
        // Brute = O(n^2)
        for (int i = 0; i < n; i++) {
            System.out.println(i);
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    placed++;
                    break;
                }
            }
        }

        return n - placed;
    }
}