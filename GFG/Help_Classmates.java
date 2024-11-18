//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Optimal Approach 
	        // O(n) TC and SC
	        
	        // Just push if you cant solve problem on top of stack 
	        
	        // if u can solve, then solve and push curr
	        
	        // remaining elements in stack are unsolvable
	    int[] ans = new int[n];
	    Stack<Integer> st = new Stack();
	    for(int i=0;i<n;i++){
	        ans[i] = -1;
	        
	        while(st.size()>0 && arr[st.peek()]>arr[i]){
	            int idx = st.pop();
	            ans[idx] = arr[i];
	        }
	        
	        st.push(i);
	        
	    }
	    
	    return ans;
	} 
}
