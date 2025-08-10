class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(hs.contains(arr[i]+x) || hs.contains(arr[i]-x)){
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }
}
