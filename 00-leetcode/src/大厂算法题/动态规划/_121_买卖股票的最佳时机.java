package 大厂算法题.动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author rnang0
 * @date 2020/10/20
 **/
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 迭代的前面最小的值
        int min = prices[0];

        // 迭代的最大利润
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

    /**
     * 使用动态规划求解
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (prices == null || length == 0) {
            return 0;
        }
        // 初始化，差值数组
        int a[] = new int[length];
        a[0] = 0;
        for (int i = 1; i < length; i++) {
            a[i] = prices[i] - prices[i - 1];
        }

        // 求解最大连续子序列和，即是最大利润
        // int dp[] = new int[length]; 优化成一维数组
        int dp = a[0];
        int max = dp;
        for (int i = 1; i < length; i++) {
            // 前面和大于0，才加起，不然越加越少
            if (dp < 0) {
                dp = a[i];
            } else {
                dp += a[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }
}
