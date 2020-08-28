package com.embedded.dp;

/**
 * 动态规划解决最大连续子序列和
 * 数组类问题，状态一般为与nums[i]有关
 * @author rnang0
 * @date 2020/8/28
 **/
public class MaxSubarray {

    /**
     * 最大连续子序列和
     * （1）状态转移方程：如果dp[i - 1] > 0，则为dp[i] = dp[i - 1] + nums[i]
     * 否则就直接为nums[i]
     * （2）初始状态：dp[0] = nums[0]
     * （3）则最大连续子序列和 = max{dp[i]，i∈[0, nums.length]}
     * @param nums
     * @return
     */
    public static int maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        // 初始值为nums[0]，为nums只有一个元素的情况
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp <= 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }
}
