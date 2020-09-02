package com.embedded;

/**
 * 字符串暴力算法
 * @author rnang0
 * @date 2020/9/1
 **/
public class BruteForce {

    /**
     * 字符串匹配：暴力优化
     * 每轮比较ti不动，只有pi动
     * 比较完后ti才++，作为每轮首个比较字符的位置
     * 返回首字符索引，无则返回-1
     * @param text
     * @param pattern
     * @return
     */
    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) {
            return -1;
        }

        int tiMax = tlen - plen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < plen; pi++) {
                if (text.charAt(ti + pi) != pattern.charAt(pi)) {
                    break;
                }
            }
            if (pi == plen) {
                return ti;
            }
        }
        return -1;
    }
}
