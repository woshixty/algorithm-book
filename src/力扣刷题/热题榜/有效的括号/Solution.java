package 力扣刷题.热题榜.有效的括号;

public class Solution {
    public boolean isValid(String s) {
        final char[] chars = s.toCharArray();
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '{':
                case '[':
                    stack[top++] = aChar;
                    break;
                case ')':
                    if (stack[--top] != '(')
                        return false;
                case '}':
                    if (stack[--top] != '{')
                        return false;
                case ']':
                    if (stack[--top] != '[')
                        return false;
            }
        }
        return top == 1;
    }
}
