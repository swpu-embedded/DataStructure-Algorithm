package 大厂算法题.动态规划;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author rnang0
 * @date 2020/10/19
 **/
public class _剑指_Offer_47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
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
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int maxValueByOneDimensional(int[][] grid) {
        // 拿到行列大小
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[] = new int[cols];

        dp[0] = grid[0][0];
        // 赋初始值
        for (int i = 1; i < cols; i++) {
            int col = i;
            int j = i;
            while (j >= 0) {
                dp[col] += grid[0][j];
                j--;
            }
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == 0) {
                    dp[0] = 0;
                    int j = row;
                    while (j >= 0) {
                        dp[col] += grid[j][0];
                        j--;
                    }
                } else {
                    dp[col] = Math.max(dp[col], dp[col - 1]) + grid[row][col];
                }
            }
        }
        return dp[cols - 1];
    }
}
