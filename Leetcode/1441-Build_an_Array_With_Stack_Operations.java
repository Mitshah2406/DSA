class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList();

        int i = 1; // for stream of integers from 1..n
        int j = 0; // for target arr idxs
        int targetLen = target.length;
        while(i<=n && j<targetLen){
            int curr = i;
            if(i==target[j]){
                i++;
                j++;
                res.add("Push");
            }else if(i<target[j]){
                res.add("Push");
                res.add("Pop");
                i++;
            }
        }

        return res;
    }
}