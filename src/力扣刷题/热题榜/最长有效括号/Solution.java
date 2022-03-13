package 力扣刷题.热题榜.最长有效括号;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxtimes = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxtimes = Math.max(i - stack.peek(), maxtimes);
                }
            }
        }
        return maxtimes;
    }
}
