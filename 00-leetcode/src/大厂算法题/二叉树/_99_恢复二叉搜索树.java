package 大厂算法题.二叉树;

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

        traverseTree(root.right);
    }

    /**
     * 使用 O(1) 空间复杂度的解法
     * @param root
     */
    public void recoverTree1(TreeNode root) {

    }
}
