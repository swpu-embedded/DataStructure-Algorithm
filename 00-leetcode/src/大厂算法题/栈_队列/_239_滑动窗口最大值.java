package 大厂算法题.栈_队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _239_滑动窗口最大值 {

    /**
     * 暴力改进版（适用于递增数组O（n））
     * 打算不进行k遍，则找出最大值，然后往后走，依次找到最大值
     * 如果最值不在窗口，则再进行k遍遍历，找最值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] maxes = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        maxes[0] = nums[maxIndex];

        for (int li = 1; li < maxes.length; li++) {
            int ri = li + k - 1;
            // 往后移一位后，发现最大值出了窗口
            if (maxIndex < li) {
                // 再遍历一下窗口找最值
                maxIndex = li;
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
            //写"="号，为了让最大值往后挪，避免出窗口
            } else if (nums[ri] >= nums[maxIndex]){
                maxIndex = ri;
            }
            maxes[li] = nums[maxIndex];
        }
        return maxes;
    }

    /**
     * 暴力（O（k * n）的优化）
     * 找到一种结构，使得结构头部就是该窗口的最大值，留小的没有意义。
     * 做法：维护一个双端队列
     * 1.队列存放的是索引值
     * 2.队列中的索引从头到尾对应的元素值逐渐减小（大的元素往前靠）
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowByDeque(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 删除队列中索引对应元素值小的
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i] ) {
                deque.pollLast();
            }

            // 将该索引入队
            deque.offerLast(i);

            // 由于要得到窗口的最大值，所以要检查窗口的所以是否合法
            int w = i - k + 1;
            if (w < 0) continue;

            // 每次只挪动一次，所以就删一个，保证队列中索引在窗口内
            if (deque.peekFirst() < w) {
                deque.pollFirst();
            }

            // 设置最大值
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
