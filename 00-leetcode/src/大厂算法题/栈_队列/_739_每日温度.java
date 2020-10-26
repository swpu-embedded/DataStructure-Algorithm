package 大厂算法题.栈_队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author rnang0
 * @date 2020/9/15
 **/
public class _739_每日温度 {
    /**
     * 倒推法1解决，时间复杂度太高
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        if (length == 1) {
            return new int[] {0};
        }

        int[] rightIndexes = new int[length];
        rightIndexes[length - 1] = 0;


        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            if (T[j] > T[i]) {
                rightIndexes[i] = j - i;
            } else {
                while (T[j] <= T[i]) {
                    j++;
                    if (j == length) {
                        break;
                    }
                }
                rightIndexes[i] = j == length ? 0 : j - i;
            }
        }
        return rightIndexes;
    }

    /**
     * 倒推法改进：
     * 有些位置可以不用遍历，因为后面一格的rightIndex知道
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        if (length == 1) {
            return new int[] {0};
        }

        int[] rightIndexes = new int[length];
        rightIndexes[length - 1] = 0;


        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[j] > T[i]) {
                    rightIndexes[i] = j - i;
                    break;
                } //else if (T[j] == T[i]){
//                    if (rightIndexes[j] == 0) {
//                        rightIndexes[i] = 0;
//                    } else {
//                        rightIndexes[i] = rightIndexes[j] + j - i;
//                    }
//                    break;
//                } else {
//                    if (rightIndexes[j] == 0) {
//                        rightIndexes[i] = 0;
//                        break;
//                    } else {
//                        j = j + rightIndexes[j];
//                    }
//                }
                // 优化代码，后面一格的rightIndex为0，就不需要知道
                else if (rightIndexes[j] == 0){
                    rightIndexes[i] = 0;
                    break;
                }
                // 等于后面一格的温度，则rightIndex为后面一格的rightIndex
                else if (T[j] == T[i]){
                    rightIndexes[i] = rightIndexes[j] + j - i;
                    break;
                } else {
                    j = j + rightIndexes[j];
                }
            }
        }
        return rightIndexes;
    }

    /**
     * 实际上就是找到右边第一个值比它的值大的索引
     * @param T
     * @return
     */
    public int[] dailyTemperaturesByStack(int[] T) {
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
