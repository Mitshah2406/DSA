// User function Template for Java

class Solution {
    class Pair{
        int steps;
        int num;
        public Pair(int steps, int num){
            this.steps=steps;
            this.num=num;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int MOD = 100000;
        HashSet<Integer> hs = new HashSet();
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(0,start));
        
        int n = arr.length;
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int num = rem.num;
            int steps = rem.steps;
            if(num==end){
                return steps;
            }
            for(int i=0;i<n;i++){
                int ans = (arr[i] * num) % MOD;
                if(!hs.contains(ans)){
                    hs.add(ans);
                    q.add(new Pair(steps+1, ans));
                }
            }
        }
        
        return -1;
        
    }
}
