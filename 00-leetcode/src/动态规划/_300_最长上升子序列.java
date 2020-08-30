package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author rnang0
 * @date 2020/8/29
 **/
public class _300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp为以nums[i]结尾的...长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[i] > nums[j]) {
                    // 如果dp[j] + 1大于上一次赋的值dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 取每次循坏的最大值
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
