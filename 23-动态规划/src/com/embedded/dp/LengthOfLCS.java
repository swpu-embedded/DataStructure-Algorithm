package com.embedded.dp;

/**
 * 动态规划求最长公共子序列的长度
 * @author rnang0
 * @date 2020/8/29
 **/
public class LengthOfLCS {

    /**
     * 求最长公共子序列的长度
     * 优化：采用滚动数组，因为每次只用到了两行的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public static int longestCommonSubsequence(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
            nums2 == null || nums2.length == 0) {
            return 0;
        }

        // 行采用滚动数组
        int[][] dp = new int[2][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            // 前一行和当前行
            int prevRow = (i - 1) & 1;
            int row = i & 1;
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[row][j] = dp[prevRow][j - 1] + 1;
                } else {
                    // 如果最后一位不相等，则对称判断前面的取最大值
                    dp[row][j] = Math.max(dp[prevRow][j], dp[row][j - 1]);
                }
            }
        }
        return dp[nums1.length & 1][nums2.length];
    }

    /**
     * 求最长公共子序列的长度
     * 优化：一维数组实现，每次使用只需要用到 这一行 和 前一行 的数据
     * @param nums1
     * @param nums2
     * @return
     */
    public static int longestCommonSubsequence1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
            nums2 == null || nums2.length == 0) {
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
