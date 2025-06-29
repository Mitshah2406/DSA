class Solution {
    /*
        Time = O(nlogn) + O(m)
        Space = O(n)
    */
    class Pair implements Comparable<Pair>{
        int v;
        int cnt;
        public Pair(int v, int cnt){
            this.v=v;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Pair o){
            int ans = o.cnt-this.cnt;
            if(ans==0){
                return this.v-o.v;
            }
            return ans;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Integer> hm = new HashMap();
        ArrayList<Pair> arr = new ArrayList();
        for(int i=0;i<n;i++){
            hm.put(i,0);
        }
        for(int r[]: roads){
            int u = r[0];
            int v = r[1];

            hm.put(u, hm.get(u)+1);
            hm.put(v, hm.get(v)+1);
        }
        for(Map.Entry<Integer, Integer> e: hm.entrySet()){
            arr.add(new Pair(e.getKey(), e.getValue()));
        }

        Collections.sort(arr);

        long ans = 0;
        int imp[] = new int[n];

        int num = n;

        for(int i=0;i<n;i++){
            Pair p = arr.get(i);
            imp[p.v] = num--;
        }

        for(int road[]: roads){
            int u = road[0];
            int v = road[1];

            long sum = (imp[u]) + (imp[v]);
            ans+=sum;
        }
        return ans;
    }
}