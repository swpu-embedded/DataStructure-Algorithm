package 大厂算法题.字符串;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author rnang0
 * @date 2020/9/24
 **/
public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (s == null || length == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        // 上一个重复字符的位置，默认为-1，没有在里面，因为跟最左边比
        int[] prevIndex = new int[128];
        for (int i = 0; i < prevIndex.length; i++) {
            prevIndex[i] = -1;
        }
        // 设第一个字符（初值）
        prevIndex[chars[0]] = 0;
        // 以i位置字符结尾的最长不重复子串的开始位置（最左边索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置上次出现的位置
            int pi = prevIndex[chars[i]];
            // 上次的字符在里面，那就不得行了
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIndex[chars[i]] = i;
            // i - li + 1就是每个位置的最长不重复子串长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
