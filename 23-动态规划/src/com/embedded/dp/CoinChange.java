package com.embedded.dp;

/**
 * 动态规划解决找零钱问题
 * @author rnang0
 * @date 2020/8/27
 **/
public class CoinChange {
    private int n;

    private static int dp[];

    private static int faces[];

    public CoinChange(int n) {
        this.n = n;
    }

    /**
     * 由外界传递面值
     * @param n
     * @param faces
     * @return
     */
    public static int coins5(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) {
            return -1;
        }
        dp = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
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
        return dp[n];
    }

    /**
     * 递归方式实现，存在大量重复计算
     * @param n
     * @return
     */
    public static int coins1(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1 ) {
            return 1;
        }

        int min1 = Math.min(coins1(n - 25), coins1(n - 20));
        int min2 = Math.min(coins1(n - 5), coins1(n - 1));
        return Math.min(min1, min2) + 1;
    }

    /**
     * 记忆化搜索优化（自顶向下的调用）
     * @param n
     * @return
     */
    public static int coins2(int n) {
        if (n < 1) {
            return -1;
        }
        // dp[n]:凑够n，所需要的硬币个数
        dp = new int[n + 1];
        dp[1] = dp[5] = dp[20] = dp[25] = 1;
        return coins2(n, dp);
    }

    public static int coins2(int n, int[] dp) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] == 0) {
            int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 递推（自底向上）
     * @param n
     * @return
     */
    public static int coins3(int n) {
        if (n < 1) {
            return -1;
        }
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1];
            if (i >= 25) {
                min = Math.min(dp[i - 25], min);
            }
            if (i >= 20) {
                min = Math.min(dp[i - 20], min);
            }
            if (i >= 5) {
                min = Math.min(dp[i - 5], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 递推求解，打印出求解每一分下的硬币情况
     * @param n
     * @return
     */
    public static int coins4(int n) {
		if (n < 1) return -1;
		dp = new int[n + 1];

		// faces[i]是凑够i分时最后那枚硬币的面值
		faces = new int[dp.length];
		for (int i = 1; i <= n; i++) {
			int min = dp[i - 1];

			// 满足一个面值，就对一个面值进行 +1
            // 输出时，从后遍历
            faces[i] = 1;
			if (i >= 5 && dp[i - 5] < min) {
				min = dp[i - 5];
				faces[i] = 5;
			}
			if (i >= 20 && dp[i - 20] < min) {
				min = dp[i - 20];
				faces[i] = 20;
			}
			if (i >= 25 && dp[i - 25] < min) {
				min = dp[i - 25];
				faces[i] = 25;
			}
			dp[i] = min + 1;
			print(faces, i);
		}
//		print(faces, n);
		return dp[n];
	}

	static void print(int[] faces, int n) {
		System.out.print("[" + n + "] = ");
		while (n > 0) {
			System.out.print(faces[n] + " ");
			n -= faces[n];
		}
		System.out.println();
	}

}
