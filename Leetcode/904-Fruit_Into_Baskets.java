class Solution {
    public int totalFruit(int[] fruits) {
        /**
        We have two baskets, we can collect infinite num of fruits of same type in each basket
        but there is a catch, once we start collecting, we cannot skip fruits in between and pick some
        fruits later

        So we can frame this problem like,
        Max Length Subarray with at most 2 types of elements

        Time Complexity = O(N+N)
        Space Complexity = O(N)
         */
        int n = fruits.length;

        int left = 0;
        int right = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;

        while(right<n){
            hm.put(fruits[right], hm.getOrDefault(fruits[right],0)+1);
            while(hm.size()>2 && left<n){
                int val = hm.get(fruits[left]);
                val--;
                if(val>0){
                    hm.put(fruits[left],val);
                }else{
                    hm.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}