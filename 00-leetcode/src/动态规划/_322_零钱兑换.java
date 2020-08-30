package 动态规划;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * @author rnang0
 * @date 2020/8/29
 **/
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount ; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : coins) {
                // dp[i - face]为-1，则没有零钱匹配
                if (i < face || dp[i - face] < 0) {
                    continue;
                }
                min = Math.min(dp[i - face], min);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
