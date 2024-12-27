class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        Stack<String> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char curr = arr[i];

            if (curr != ']') {
                st.push(String.valueOf(curr));
            } else {
                // 1st breakpoint for pop is opening bracket [
                // 2nd is take aage ka number
                // then do required operation again push
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !(st.peek().equals("["))) {
                    sb.insert(0,st.pop());
                }
                // pop opening bracket
                st.pop();
               
                // now look for numbers
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }
                
                
                int repeatCount = Integer.parseInt(num.toString());
                String res = sb.toString().repeat(repeatCount);
                st.push(res);
            }

        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }

}