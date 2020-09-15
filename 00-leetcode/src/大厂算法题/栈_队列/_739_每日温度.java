package 大厂算法题.栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author rnang0
 * @date 2020/9/15
 **/
public class _739_每日温度 {
    /**
     * 实际上就是找到右边第一个值比它的值大的索引
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1) {
            return new int[] {0};
        }

        int[] rightIndexes = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                rightIndexes[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return rightIndexes;
    }
}
