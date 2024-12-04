class CustomStack {

    // Better Approach
    // ArrayList<Integer> st;
    // int currSize;
    // int k;
    // public CustomStack(int maxSize) {
    //     k = maxSize;
    //     currSize=0;
    //     st = new ArrayList();
    // }
    
    // public void push(int x) {
    //     if(currSize<k){
    //         st.add(x);
    //         currSize++;
    //     }
    // }
    
    // public int pop() {
    //     if(currSize!=0){
    //         return st.remove(--currSize);
    //     }else{
    //         return -1;
    //     }
    // }
    
    // public void increment(int k, int val) {
    //     for(int i=0;i<Math.min(k,currSize);i++){
    //         int old = st.get(i);
    //         st.set(i, old+val);
    //     }
    // }

    // Best
    int[] arr;
    int currSize;
    int k;
    public CustomStack(int maxSize) {
        k = maxSize;
        currSize=0;
        arr = new int[maxSize];
        Arrays.fill(arr,-1);
    }
    
    public void push(int x) {
        if(currSize<k){
            arr[currSize] = x;
            currSize++;
        }
    }
    
    public int pop() {
        if(currSize!=0){
            return arr[--currSize];
        }else{
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,currSize);i++){
            arr[i] = arr[i] +val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */