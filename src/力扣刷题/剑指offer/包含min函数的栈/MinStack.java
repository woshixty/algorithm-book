package 力扣刷题.剑指offer.包含min函数的栈;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack();
        stackB = new Stack();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.empty() || x <= stackB.peek()) {
            stackB.push(x);
        }
    }

    public void pop() {
        if (stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
