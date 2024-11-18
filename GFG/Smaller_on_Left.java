//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> ans = new ArrayList();
        Stack<Integer> st = new Stack();
        int res[] = new int[n];
        for(int i=n-1;i>=0;i--){
            res[i] = -1;
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                int idx = st.pop();
                res[idx] = a[i];
            }
            st.push(i);
        }
        
        for(int i:res){
            ans.add(i);
        }
        
        return ans;
    }
}