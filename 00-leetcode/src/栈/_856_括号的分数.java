package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * <p>
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 */
public class _856_括号的分数 {
    public static void main(String[] args) {
        System.out.println(Solution.scoreOfParentheses("(())()"));
    }

    /**
     * 方法一
     */
    static class Solution1 {
        public static int scoreOfParentheses(String S) {
            int d = 0;
            int s = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    d++;
                } else {
                    d--;
                    if (S.charAt(i - 1) == '(')
                        s += 1 << d;
                }
            }
            return s;
        }
    }

    /**
     * 栈思想
     */
    static class Solution {
        public static int scoreOfParentheses(String S) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (char s : S.toCharArray()) {
                if (s == '(') {
                    stack.push(0);
                } else {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b + Math.max(a * 2, 1));
                }
            }
            return stack.pop();
        }
    }
}
