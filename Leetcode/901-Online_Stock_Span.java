class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> arr;
    int curr;
    public StockSpanner() {
        st = new Stack();
        arr = new ArrayList();
        curr = 0;
    }
    
    public int next(int price) {
        arr.add(price);
        int ans = 0;
        while(!st.isEmpty() && arr.get(st.peek())<=arr.get(curr)){
            int idx = st.pop();
        }
        if(st.isEmpty()){
            ans = curr+1;
        }else{
            ans = curr - st.peek();
        }
        st.push(curr);
        curr++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */