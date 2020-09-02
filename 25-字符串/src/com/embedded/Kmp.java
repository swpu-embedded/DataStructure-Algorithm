package com.embedded;

/**
 * Kmp算法
 * @author rnang0
 * @date 2020/9/2
 **/
public class Kmp {

    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }
        int tlen = text.length();
        int plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) {
            return -1;
        }

        // 获取子字符串的next数组
        int[] next = next(pattern);

        int tiMax = tlen - plen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < plen; pi++) {
                if (text.charAt(ti + pi) != pattern.charAt(pi)) {
                    // 失配就到next数组的位置
                    pi = next[pi];
                }
            }
            if (pi == plen) {
                return ti;
            }
        }
        return -1;
    }

    /**
     * 获取子字符串的next数组（前缀需要移动的值，与前缀对齐）
     * @param pattern
     * @return
     */
    private static int[] next(String pattern) {
        int length = pattern.length();

        int[] next = new int[length];
        int i = 0;
        int iMax = length - 1;
        // 初始化为-1
        int n = next[i] = -1;
        // 遍历字符串
        while (i < iMax) {
            // 等于：前缀的位置找到
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                // 后一个元素失配后，移动到n处，移动++n个单位
                next[++i] = ++n;
            } else {
                // n置0
                n = next[n];
            }
        }
        return next;
    }
}
