package 大厂算法题.字符串;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * @author rnang0
 * @date 2020/9/21
 **/
public class _面试题_01_09_字符串轮转 {
    /**
     * 暴力法O（n^2）的改进
     * 某一部分相等，试一试通分来解决，不太能s1与s2来拼
     * 发现子串是循环拼接且满足时钟周期的特点，所以拼接多个时钟周期(两个s1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 == 0 && length2 == 0) {
            return true;
        } else if (length1 != length2) {
            return false;
        }
        // 可以考虑使用KMP算法，效率较高
        // return (s1 + s1).contains(s2);

        String s = s1 + s1;
        int length = s.length();
        char[] charsS = s.toCharArray();
        char[] charsS2 = s2.toCharArray();
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = 0; j < length2 && k < length; j++, k++) {
                if (charsS[k] != charsS2[j]) {
                    break;
                }
                if (j == length2 - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
