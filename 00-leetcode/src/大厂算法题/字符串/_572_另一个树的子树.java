package 大厂算法题.字符串;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author rnang0
 * @date 2020/9/21
 **/
public class _572_另一个树的子树 {

    /**
     * 将树序列化成字符串，前中后序列化都可以
     * 例如：前序遍历序列化成字符串为!3！4！1！#！#！2！#！#！5
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 1.前序遍历序列化s和t
        String s1 = serialize(s);
        String s2 = serialize(t);
        // 2.字符串子串比较
        return s1.contains(s2);
    }

    private String serialize(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        sb.append("!");
        serializeByPre(s, sb);
        return sb.toString();
    }

    /**
     * 前序遍历序列化
     * @param root
     * @param sb
     */
    private void serializeByPre(TreeNode root, StringBuilder sb) {
        sb.append(root.val).append("!");

        if (root.left == null) {
            // 结束条件
            sb.append("#!");
        } else {
            serializeByPre(root.left, sb);
        }
        if (root.right == null) {
            sb.append("#!");
        } else {
            serializeByPre(root.right, sb);
        }
    }
}
