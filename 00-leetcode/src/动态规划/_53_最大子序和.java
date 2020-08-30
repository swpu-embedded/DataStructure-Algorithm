package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author rnang0
 * @date 2020/8/29
 **/
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = dp;
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
