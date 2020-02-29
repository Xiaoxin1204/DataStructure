package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class _150_逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        int i = Solution.evalRPN(tokens);
        System.out.println(i);
    }


    static class Solution {

        public static int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            int op1;
            int op2;
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        op1 = stack.pop();
                        op2 = stack.pop();
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        op1 = stack.pop();
                        op2 = stack.pop();
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        op1 = stack.pop();
                        op2 = stack.pop();
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        op1 = stack.pop();
                        op2 = stack.pop();
                        stack.push(op2 / op1);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                        break;
                }
            }
            return stack.pop();
        }
    }
}
