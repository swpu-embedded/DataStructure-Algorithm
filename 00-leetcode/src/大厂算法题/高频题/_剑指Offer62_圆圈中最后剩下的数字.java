package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author rnang0
 * @date 2020/11/17
 **/
public class _剑指Offer62_圆圈中最后剩下的数字 {

    /**
     * f(n,m) = (f(n - 1,m) + m) % n
     * 使用递归解决
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        // 一个人，要返回第m个，那就是这个人编号为0
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

    /**
     * f(n,m) = (f(n - 1,m) + m) % n
     * 已知一些初始值（前面的）和递推式，需要顶层的值，则迭代求
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        // 一个人，要返回第m个，那就是这个人编号为0
        if (n == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
