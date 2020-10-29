package 大厂算法题.二叉树;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 * @author rnang0
 * @date 2020/10/27
 **/
public class _333_最大BST子树 {
    /**
     * 自顶向下
     * 返回root所在子树的最大BST子树节点个数
     * 如果不是BST树，则返回左右子树的
     * @param root
     * @return
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBST(root)) {
            return nodesCount(root);
        }
        // 否则就返回左右子树中最多的
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 判断以root为根结点的树，是否为BST树
     * @param root
     * @return
     */
    private boolean isBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue)
            && minValue < root.val && root.val < maxValue) {
           return true;
        }
        return false;
    }

    /**
     * 返回root的节点数目
     * @param root
     * @return
     */
    private int nodesCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return nodesCount(root.left) + nodesCount(root.right) + 1;
    }
}
