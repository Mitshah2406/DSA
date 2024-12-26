class Pair {
    int frq;
    char c;

    public Pair(char c, int frq) {
        this.frq = frq;
        this.c = c;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {

        // using two stacks 
        // -> Time O(n)+O(n)
        // -> Space O(n)+O(n)+O(n) [Two Stacks and a str builder]
        // Stack<Integer> frqSt = new Stack();
        // Stack<Character> st = new Stack();

        // int n = s.length();

        // for(int i=0;i<n;i++){
        //     char curr = s.charAt(i);
        //     if(st.isEmpty() || st.peek()!=curr){
        //         frqSt.push(1);
        //         st.push(curr);
        //     }else if(st.peek()==curr){
        //         frqSt.push(frqSt.pop()+1);

        //         if(frqSt.peek()==k){
        //             for(int j=0;j<k-1;j++){
        //                 st.pop();
        //             }
        //             frqSt.pop();
        //         }else{
        //             st.push(curr);
        //         }
        //     }
        // }

        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }
        // return sb.reverse().toString();


        // better -
            // time - O(n) + O(n)
            // space - O(2n)

        Stack<Pair> st = new Stack();

        int n = s.length();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(st.isEmpty() || st.peek().c!=curr){
                st.push(new Pair(curr,1));
            }else if(st.peek().c==curr){
                st.peek().frq++;

                if(st.peek().frq==k){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.pop();
            for(int i=0;i<p.frq;i++){
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();

       
    }
}