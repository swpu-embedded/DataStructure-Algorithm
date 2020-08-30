package com.embedded.dp;

/**
 * 动态规划求解最长公共子串
 * @author rnang0
 * @date 2020/8/30
 **/
public class LengthOfLCSubstring {

    /**
     * 相等则dp[i][j] = dp[i - 1][j - 1] + 1;
     * 可采取一维数组优化
     * @param str1
     * @param str2
     * @return
     */
    public static int lcSubstring(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        if (char1.length == 0 || char2.length == 0) {
            return 0;
        }

        int[] dp = new int[char2.length + 1];
        int max = 0;
        for (int i = 1; i <= char1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= char2.length; j++) {
                // 保存左上角值，避免被改
                int leftTop = cur;
                cur = dp[j];
                // 不相同则默认为0
                if (char1[i - 1] != char2[j - 1]) {
                    dp[j] = 0;
                } else{
                    dp[j] = leftTop + 1;
                    max = Math.max(dp[j], max);
                }
            }
        }
        return max;
    }
}
