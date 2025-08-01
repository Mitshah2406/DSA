class MinStack {
    Stack<Integer> st, minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty() && minStack.isEmpty()) {
            st.push(val);
            minStack.push(val);
            return;
        }

        st.push(val);

        if (val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */