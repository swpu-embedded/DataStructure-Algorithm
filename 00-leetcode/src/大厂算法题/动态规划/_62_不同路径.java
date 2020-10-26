package 大厂算法题.动态规划;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * @author rnang0
 * @date 2020/10/19
 **/
public class _62_不同路径 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
