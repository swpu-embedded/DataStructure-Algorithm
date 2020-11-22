package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author rnang0
 * @date 2020/11/16
 **/
public class _50_Powx_n {

    /**
     * 使用递归分治解决
     * 陷阱：n可能为负数，负数分治到最后会到-1，而-1 >> 1还是-1，则-1需要直接返回
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // n可能为负数，则-1需要直接返回
        if (n == -1) {
            return 1 / x;
        }

        // 判断指数是否为奇数
        boolean flag = (n & 1) == 1;

        double half = myPow(x, n >> 1);
        return flag ? half * half * x : half * half;
    }

    /**
     * 快速幂解决
     * 21 = 10101(二进制)
     * 3^21 = 3^(1*2^0 + 0*2^1 + 1*2^2 + 0*2^3 + 1*2^4)
     * 如果指数是负数，则最后分之1即可，1/3^21
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double res = 1.0;
        // 考虑边界条件：n 是 32 位有符号整数，其数值范围是 [?231, 231 ? 1] 。
        long y = n;
        if (n < 0) {
            y = -((long)n);
        }

        while (y > 0) {
            // 取n的最后一个二进制位，看乘不乘
            if ((y & 1) == 1) {
                res *= x;
            }

            // 下一次的底数
            x = x * x;

            // 舍弃到最后一位
            y = y >> 1;
        }
        return (n < 0) ? (1 / res) : res;
    }
}
