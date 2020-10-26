package 大厂算法题.动态规划;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * @author rnang0
 * @date 2020/10/20
 **/
public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int temp1 = 0;
                if (chars1[i - 1] == chars2[j - 1]) {
                    temp1 = dp[i - 1][j - 1];
                } else {
                    temp1 = dp[i - 1][j - 1] + 1;
                }
                int temp2 = dp[i - 1][j] + 1;
                int temp3 = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(temp1, temp2), temp3);
            }
        }

        return dp[length1][length2];
    }
}
