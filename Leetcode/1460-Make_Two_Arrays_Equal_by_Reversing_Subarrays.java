class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {

        // 1st - nlogn -
        // Arrays.sort(arr);
        // Arrays.sort(target);

        // for (int i = 0; i < target.length; i++) {
        // if (target[i] != arr[i])
        // return false;
        // }
        // return true;

        // O(2N)
        // HashMap<Integer, Integer> hm = new HashMap();

        // for (int i : arr) {
        // hm.put(i, hm.getOrDefault(i, 0) + 1);
        // }

        // for (int i : target) {
        // if (!hm.containsKey(i)) {
        // return false;
        // } else {
        // int val = hm.get(i);
        // val--;
        // hm.put(i, val);
        // if (val <= 0) {
        // hm.remove(i);
        // }
        // }
        // }
        // return true;

        // Optimal Soln
        int ans[] = new int[1001];
        for (int i : target) {
            ans[i]++;
        }

        for (int i : arr) {
            ans[i]--;
        }
        for (int i : ans) {
            if (i != 0)
                return false;
        }
        return true;
    }
}