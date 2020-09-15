package 大厂算法题.栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _155_最小栈 {

    /**
     * 获取栈的最小元素，O（1）复杂度，则用空间换时间
     * 维护两个栈，其中一个栈minStack存前n个元素的最小值
     */
    class MinStack {

        private Stack<Integer> stack;

        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                Integer top = minStack.peek();
                if (x <= top) {
                    minStack.push(x);
                } else {
                    minStack.push(top);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
