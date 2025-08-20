class Solution {
    /*
    Time - O(N^2), Space - O(K)
    */
    private void brute(int arr[], int n, ArrayList<Integer> map, int k){
        for(int i=0;i<n;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i;j<n;j++){
                hs.add(arr[j]);
                if(j-i+1==k){
                    map.add(hs.size());
                    break;
                }
            }
        }
    }
    /*
    Time - O(N), Space - O(K)
    As k is given, we can use sliding window, where window size is k
    */
    private void optimal(int arr[], int n, ArrayList<Integer> map, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<k;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        map.add(hm.size());
        
        for(int i=k;i<n;i++){
            // remove i-k
            int occ = hm.get(arr[i-k])-1;
            if(occ==0){
                hm.remove(arr[i-k]);
            }else{
                hm.put(arr[i-k], occ);
            }
            
            // add i
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
            
            map.add(hm.size());
        }

    }
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> map = new ArrayList<>();
        int n = arr.length;
        // brute(arr, n, map, k);
        optimal(arr, n, map, k);
        return map;
    }
}
