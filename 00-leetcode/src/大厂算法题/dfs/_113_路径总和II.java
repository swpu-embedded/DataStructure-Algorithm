package 大厂算法题.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author rnang0
 * @date 2020/11/15
 **/




public class _113_路径总和II {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
        val = x;
    }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        // 返回空集合，通过leetcode判题结果得出
        if (root == null) {
            return list;
        }

        // 进入第一层
        dfs(root, sum, new ArrayList<>(), list);
        return list;
    }

    private void dfs(TreeNode node, int sum, List<Integer> result, List<List<Integer>> list) {
        // 假设进入最后一层，不能再深入
        if (node == null) {
            return;
        }

        // sum迭代将val存起来
        sum -= node.val;
        result.add(node.val);
        // 判断node的左右，简洁一下有一个不为null都进入
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                list.add(new ArrayList<>(result));
            }
        } else {
            dfs(node.left, sum, result, list);
            dfs(node.right, sum, result, list);
        }
        // 还原
        result.remove(result.size() - 1);
    }
}
