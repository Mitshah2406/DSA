class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int precedence(char operator){
        if(operator=='^'){
            return 3;
        }else if(operator=='/' || operator=='*'){
            return 2;
        }else{
            return 1;
        }
    }
    public static String infixToPostfix(String exp) {

        Stack<StringBuilder> operand = new Stack();
        Stack<Character> operator = new Stack();
        StringBuilder s = new StringBuilder(exp);
        
        for(int i=0;i<exp.length();i++){
            char curr = s.charAt(i);
            
            if((curr>='a' && curr<='z') || (curr>='0' && curr<='9') ){
                StringBuilder pushed = new StringBuilder();
                pushed.append(curr);

                operand.push(pushed);

            }else{
                if(curr=='('){
                    operator.push(curr);
                }else if(curr==')'){
                    while(operator.peek()!='('){
                        char popped = operator.pop();
                        StringBuilder second = operand.pop();
                        StringBuilder first = operand.pop();
                         StringBuilder res = new StringBuilder();
                        res.append(first);
                        res.append(second);
                        res.append(popped);
                        
                        operand.push(res);
                    }
                    operator.pop();
                }else{
                    int precedenceCurr = precedence(curr);
                    
                    while(!operator.isEmpty() && operator.peek()!='(' && precedence(operator.peek())>=precedenceCurr){
                        char popped = operator.pop();

                        StringBuilder second = operand.pop();
                        StringBuilder first = operand.pop();
                        StringBuilder res = new StringBuilder();
                        res.append(first);
                        res.append(second);
                        res.append(popped);
                        
                        operand.push(res);
                    }
                    operator.push(curr);
                }
            }
        }
        
        while(!operator.isEmpty()){
            char popped = operator.pop();
                        StringBuilder second = operand.pop();
                        StringBuilder first = operand.pop();
                        StringBuilder res = new StringBuilder();
                        res.append(first);
                        res.append(second);
                        res.append(popped);
                        
                        operand.push(res);
        }


        return operand.peek().toString();
    }
}