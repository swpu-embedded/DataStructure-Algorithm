package 大厂算法题.字符串;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author rnang0
 * @date 2020/9/22
 **/
public class _151_翻转字符串里的单词 {
    // 有效长度
    int length = 0;


    /**
     * 常规方法：先清除空格，再从后遍历，然后遇见空格，就遍历一个单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.消除空格
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }
        //2.开始逆方向遍历
        char[] charsPrint = new char[length];
        // 每个单词最后一个
        int cur = 0;
        // i + 1输出遍历指针
        int k = 0;
        int j = 0;
        boolean end = true;
        for (int i = length - 1; i >= 0; i--) {
            if (charsAfterClear[i] == ' ' || i == 0) {
                // 从i + 1遍历到cur
                if (i == 0) {
                    k = i;
                    cur = end ? i : cur;
                } else {
                    k = i + 1;
                }
                while (k <= cur) {
                    charsPrint[j++] = charsAfterClear[k++];
                }
                if (j < length - 1) {
                    charsPrint[j++] = ' ';
                }
                end = true;
            } else if (end){
                cur = i;
                end = false;
            }
        }
        return new String(charsPrint);
    }

    /**
     * 清除多余空格
     * @param chars
     * @return
     */
    private char[] clearSpace(char[] chars) {
        boolean space = true;
        // cur为“有效”位置
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        length = space ? (cur - 1) : cur;
        return chars;
    }

    /**
     * 数据结构优化，使用栈
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.消除空格
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }
        //2.开始逆方向遍历
        Stack<Character> stack = new Stack<>();
        char[] charsPrint = new char[length];
        int j = 0;
        boolean isSpace = true;
        for (int i = length - 1; i >= 0 ; i--) {
            if (charsAfterClear[i] == ' ' || i == 0) {
                if (i == 0) {
                    stack.push(charsAfterClear[i]);
                    isSpace = false;
                }
                while (!stack.isEmpty()) {
                    charsPrint[j++] = stack.pop();
                }
                if (isSpace) {
                    charsPrint[j++] = ' ';
                }
            } else {
                stack.push(charsAfterClear[i]);
            }
        }
        return new String(charsPrint);
    }


    /**
     * 常规方法的优化：清除空格后，逆序字符串，分治每个单词
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.消除空格
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }

        //2.逆序整个字符串
        reverseString(charsAfterClear, 0, length);

        //3.逐个单词逆序
        int begin = -1;
        for (int i = 0; i < length; i++) {
            if (charsAfterClear[i] != ' ') {
                continue;
            }
            reverseString(charsAfterClear, begin + 1, i);
            begin = i;
        }
        //逆序最后一个单词
        reverseString(charsAfterClear, begin + 1, length);
        return new String(charsAfterClear, 0, length);
    }

    /**
     * 逆序chars的[begin, end)
     * @param chars
     * @param begin
     * @param end
     */
    private void reverseString(char[] chars, int begin, int end) {
        end--;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
}
