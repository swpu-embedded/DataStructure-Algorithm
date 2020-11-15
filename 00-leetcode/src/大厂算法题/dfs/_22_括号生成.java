package 大厂算法题.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author rnang0
 * @date 2020/11/12
 **/
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        // 根据leetcode上判断机器得出需返回空集合
        if (n < 0) {
            return list;
        }

        dfs(0, 0, 0, n, new char[n << 1], list);
        return list;
    }

    /**
     *
     * @param index
     * @param left 左括号的已有数量
     * @param right 右括号的已有数量
     * @param n 左右括号的总个数
     * @param chars 结果字符数组
     * @param list
     */
    private void dfs(int index, int left, int right, int n, char[] chars, List<String> list) {
        // 假设进入最后一层，不能再深入
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }

        // 枚举这一层所有可能的选择，该层可能选左，可能选右
        // 选左
        if (n - left > 0) {
            chars[index] = '(';
            // 进入下一层
            dfs(index + 1, left + 1, right, n, chars, list);
        }

        // 选右
        if (n - right > 0 && right < left) {
            chars[index] = ')';
            dfs(index + 1, left, right + 1, n, chars, list);
        }
    }
}
