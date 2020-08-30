package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author rnang0
 * @date 2020/8/29
 **/
public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        if (nums1.length == 0 || nums2.length == 0) {
            return 0;
        }

        // 采用一维数组
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            // 前一个左上元素的值
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                // 赋值给leftTop，然后重新迭代
                int leftTop = cur;
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    // 如果最后一位不相等，则对称判断前面的取最大值
                    dp[j] = Math.max(dp[j],dp[j - 1]);
                }
            }
        }
        return dp[nums2.length];
    }
}
