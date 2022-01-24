package 力扣刷题.剑指offer.栈的压入弹出序列;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        int k = 0;
        for (int i : pushed) {
            stack[++top] = i;
            while (top > 0 && popped[k] == stack[top]) {
                k++;
                top--;
            }
        }
        return top == -1;
    }
}
