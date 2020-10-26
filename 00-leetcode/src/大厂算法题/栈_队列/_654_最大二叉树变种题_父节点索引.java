package 大厂算法题.栈_队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * 返回一个数组，数组里面存着每个节点的父节点的索引（如果没有父节点，就存-1）
 * @author rnang0
 * @date 2020/9/15
 **/
public class _654_最大二叉树变种题_父节点索引 {

    /**
     * 利用单调递减的栈来实现：找到左右最大的元素
     * @param nums
     * @return
     */
    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] leftIndexes = new int[nums.length];
        int[] rightIndexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            leftIndexes[i] = -1;
            rightIndexes[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                leftIndexes[i] = stack.peek();
            }

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                rightIndexes[stack.pop()] = i;
            }

            stack.push(i);
        }

        int[] parentIndexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (leftIndexes[i] == -1 && rightIndexes[i] == -1) {
                parentIndexes[i] = -1;
            }
            parentIndexes[i] = Math.max(leftIndexes[i], rightIndexes[i]);
        }
        return parentIndexes;
    }

    public static void main(String[] args) {
        _654_最大二叉树变种题_父节点索引 o = new _654_最大二叉树变种题_父节点索引();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
    	System.out.println(Arrays.toString(o.parentIndexes(nums)));
    }
}
