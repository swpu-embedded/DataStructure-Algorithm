package 大厂算法题.二叉树;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author rnang0
 * @date 2020/10/25
 **/
public class _剑指Offer68_II_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归临界条件，找到了p或者q，或者都没找到即到了null
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 对left，right进行分类讨论
        // 1.其中一个在里面，左右都返回p或者q
        // 2.两个都在里面返回，左右各自返回其值（一个p，一个q）
        // 3.p,q都不在，返回null
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
