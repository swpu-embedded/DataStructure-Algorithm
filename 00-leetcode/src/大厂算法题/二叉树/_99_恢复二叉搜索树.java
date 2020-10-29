package 大厂算法题.二叉树;

import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @author rnang0
 * @date 2020/10/26
 **/
public class _99_恢复二叉搜索树 {

    private TreeNode prev;

    private TreeNode first;

    private TreeNode second;

    public void recoverTree(TreeNode root) {
        // 利用中序遍历，进行递归调用
        traverseTree(root);

        // 交换first和second的值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseTree(root.left);

        find(root);

        traverseTree(root.right);
    }

    private void find(TreeNode root) {
        // 需要前面的值进行比较
        if (prev != null && root.val < prev.val) {
            // 第二个值可以覆盖，因为反正都是取小的值
            second = root;

            if (first != null) {
                // 因为second肯定有值
                return;
            }
            first = prev;
        }
        prev = root;
    }

    /**
     * 使用Morris解法
     * O(1) 空间复杂度
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode pred = node.left;
                // pred.right == node 表示串过了，即第二次遍历到该它打印了
                while (pred.right != null && pred.right != node) {
                    // 顺着向右一直找
                    pred = pred.right;
                }
                // 将前驱结点串起来
                if (pred.right == null) {
                    pred.right = node;
                    //迭代
                    node = node.left;
                } else {
                    // 即第二次遍历到该它执行代码了
                    find(node);
                    // 打印了就不需要right这根线了
                    // 同时node.right给node继续回去或者往右边走
                    pred.right = null;
                    node = node.right;
                }
            } else {
                // 到最左边了
                find(node);
                node = node.right;
            }
        }
        // 交换first和second的值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
