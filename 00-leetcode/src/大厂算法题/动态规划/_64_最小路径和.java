package 大厂算法题.动态规划;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author rnang0
 * @date 2020/10/19
 **/
public class _64_最小路径和 {
    public int minPathSum(int[][] grid) {
        // 拿到行列大小
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int[rows][cols];

        dp[0][0] = grid[0][0];
        // 赋初始值
        for (int i = 1; i < rows; i++) {
            int row = i;
            int j = i;
            while (j >= 0) {
                dp[row][0] += grid[j][0];
                j--;
            }
        }

        for (int i = 1; i < cols; i++) {
            int col = i;
            int j = i;
            while (j >= 0) {
                dp[0][col] += grid[0][j];
                j--;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
