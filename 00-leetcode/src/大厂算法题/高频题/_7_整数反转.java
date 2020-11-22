package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author rnang0
 * @date 2020/11/18
 **/
public class _7_整数反转 {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int mod = x % 10;
            int prevResult = result;
            result = result * 10 + mod;
            // 溢出了，前后不一致
            if ((result - mod) / 10 != prevResult) {
                return 0;
            }

            x /= 10;
        }
        return result;
    }
}
