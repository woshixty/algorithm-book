package 力扣刷题.剑指offer.用两个栈实现队列;

import java.util.Stack;

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //队列尾部插入整数
    public void appendTail(int value) {
        /**错误的地方
        while (!stack1.empty())
            stack2.push(stack1.pop());
         **/
        stack1.push(value);
    }

    //在队列头部删除整数
    public int deleteHead() {
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        if (stack2.empty())
            return -1;
        return stack2.pop();
    }
}

/**
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.empty()) {
            return stack2.pop();
        }
        if (!stack1.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
 **/
