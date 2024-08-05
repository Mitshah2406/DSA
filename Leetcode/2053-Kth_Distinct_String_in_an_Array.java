class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap();

        for (String i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        String s = "";
        int c = 0;
        int n = arr.length;
        for (int i = 0; i < n && c != k; i++) {
            if (hm.get(arr[i]) == 1) {
                c++;
                if (c == k)
                    s = arr[i];
            }
        }

      
        return s;
    }
}