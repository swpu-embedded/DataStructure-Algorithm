package com.embedded;

/**
 * 求最大连续子序列和
 * @author rnang0
 * @date 2020/8/24
 **/
public class MaxSubarray {

    /**
     * 求解[begin, end)中最大连续子序列和
     * 情况分类：
     *      1. 左边一半最大连续子序列和
     *      2. 右边一半最大连续子序列和
     *      3. 横跨两个半区的最大连续子序列和
     *      然后求其最大值
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public static int maxSubarray(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;

        // 左边一半最大连续子序列和
        int leftMaxSubarray = maxSubarray(nums, begin, mid);

        // 右边一半最大连续子序列和
        int rightMaxSubarray = maxSubarray(nums, mid, end);

        // 横跨两个半区的最大连续子序列和
        int maxLeftAndRight = maxByLeftAndRight(nums, begin, mid, end);

        return Math.max(maxLeftAndRight,
                Math.max(leftMaxSubarray,rightMaxSubarray));
    }

    /**
     * 横跨两个半区的最大连续子序列和
     * @param nums
     * @param begin
     * @param mid
     * @param end
     * @return
     */
    private static int maxByLeftAndRight(int[] nums, int begin, int mid, int end) {
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        // 一直加到区间边界，避免先递减而后又递增
        for (int i = mid - 1; i >= begin ; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        // 一直加到区间边界，避免先递减而后又递增
        for (int i = mid; i < end ; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return leftMax + rightMax;
    }
}
