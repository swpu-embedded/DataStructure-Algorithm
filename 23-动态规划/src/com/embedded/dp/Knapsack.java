package com.embedded.dp;

/**
 * 动态规划解决0-1背包问题
 * @author rnang0
 * @date 2020/8/31
 **/
public class Knapsack {

    private static int[] values = {6, 3, 5, 4, 6};

    private static int[] weights = {2, 2, 6, 5, 4};

    /**
     * 一维数组优化：只用到了上一行对应的元素，上一行前面的某个元素
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
    public static int maxValue(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 ||
            weights == null || weights.length == 0 ||
            values.length != weights.length || capacity <= 0) {
            return 0;
        }

        // dp[i][j]前i件物品（第实际是i - 1个）可选的最大承重j
        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                // if (j >= weights[i - 1]) {}

                // 该件物品装不下，容量不变
                // 选择（选该件物品、不选该件物品）比较其最大价值
                // 选择该件物品的价值
                int value = dp[j - weights[i - 1]] + values[i - 1];
                dp[j] = Math.max(value, dp[j]);
            }
        }
        return dp[capacity];
    }

    /**
     * 动态规划解决0-1背包问题
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
    public static int maxValue1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0 ||
            weights == null || weights.length == 0 ||
            values.length != weights.length || capacity <= 0) {
            return 0;
        }

        // dp[i][j]前i件物品（第实际是i - 1个）可选的最大承重j
        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                // 该件物品装不下，容量不变
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择（选该件物品、不选该件物品）比较其最大价值
                    // 选择该件物品的价值
                    int value = dp[i - 1][j - weights[i - 1]] + values[i - 1];
                    dp[i][j] = Math.max(value, dp[i - 1][j]);
                }
            }
        }
        return dp[values.length][capacity];
    }
}
