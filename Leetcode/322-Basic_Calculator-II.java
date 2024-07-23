class Solution {
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getPrecedence(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else {
            return 0;
        }
    }

    private int calc(int a, int b, char operation) {
        if (operation == '+') {
            return a + b;
        } else if (operation == '-') {
            return a - b;
        } else if (operation == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public int calculate(String s) {
        Stack<Integer> operand = new Stack();
        Stack<Character> operator = new Stack();

        int i = 0;
        int n = s.length();

        while (i < n) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // System.out.println(num);
                operand.push(num);
                i--;
            } else if (isOperator(ch)) {
                while (operator.size() > 0 && getPrecedence(operator.peek()) >= getPrecedence(ch)) {
                    char oper = operator.pop();
                    int val2 = operand.pop();
                    int val1 = operand.pop();

                    int ans = calc(val1, val2, oper);
                    // System.out.println(ans);
                    operand.push(ans);
                }
                operator.push(ch);
            }
            i++;
        }

        while (operator.size() > 0) {
            char oper = operator.pop();
            int val2 = operand.pop();
            int val1 = operand.pop();

            int ans = calc(val1, val2, oper);
            //   System.out.println(ans);
            operand.push(ans);
        }
        return operand.pop();
    }
}
