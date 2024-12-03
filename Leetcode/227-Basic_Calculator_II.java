class Solution {
    public int precedence(char op) {
        if (op == '/' || op == '*') {
            return 2;
        } else {
            return 1;
        }
    }

    public int eval(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }

    public int calculate(String s) {
        s = s.replace(" ", "");
        int n = s.length();
        Stack<Character> operator = new Stack();

        Stack<Integer> operand = new Stack();
        // System.out.println(s);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // System.out.println("IN");
                int pre = precedence(c);
                if (operator.isEmpty() || pre > precedence(operator.peek())) {
                    operator.push(c);
                    continue;
                }
                while (!operator.isEmpty() && pre <= precedence(operator.peek())) {
                    // pop
                    char oper = operator.pop();
                    int second = operand.pop();
                    int first = operand.pop();
                    int res = eval(first, second, oper);
                    operand.push(res);
                }
                operator.push(c);
            } else {
                StringBuilder sb = new StringBuilder();

                while (i < n && s.charAt(i)>47) {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;

                operand.push(Integer.parseInt(sb.toString()));
            }
            // System.out.println(operator);
            // System.out.println(operand);
        }

        while (operator.size() != 0) {
            int scd = operand.pop();
            int fst = operand.pop();

            char operation = operator.pop();

            int res = eval(fst, scd, operation);
            operand.push(res);
        }

        return operand.peek();
    }
}