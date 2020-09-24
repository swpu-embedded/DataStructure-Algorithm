package 大厂算法题.字符串;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author rnang0
 * @date 2020/9/22
 **/
public class _242_有效的字母异位词 {

    /**
     * 遍历存hash优化，只有小写就存入大小为26的数组
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (s == null || t == null || length1 != length2) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < length1; i++) {
            counts[chars1[i] - 'a']++;
        }

        // 避免开辟新空间存串2个数
        for (int i = 0; i < length2; i++) {
            if (--counts[chars2[i] - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
