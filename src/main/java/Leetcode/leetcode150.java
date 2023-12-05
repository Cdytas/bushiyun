package Leetcode;

import java.util.Stack;

public class leetcode150 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stackOfNumber = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                int b = stackOfNumber.pop();
                int a = stackOfNumber.pop();
                stackOfNumber.push(a + b);
            }
            else if (str.equals("-")) {
                int b = stackOfNumber.pop();
                int a = stackOfNumber.pop();
                stackOfNumber.push(a - b);
            }
            else if (str.equals("*")) {
                int b = stackOfNumber.pop();
                int a = stackOfNumber.pop();
                stackOfNumber.push(a * b);
            }
            else if (str.equals("/")) {
                int b = stackOfNumber.pop();
                int a = stackOfNumber.pop();
                stackOfNumber.push(a / b);
            }
            else {
                stackOfNumber.push(Integer.parseInt(str));
            }
        }
        return stackOfNumber.peek();
    }
}
