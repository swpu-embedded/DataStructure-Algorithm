package 大厂算法题.二叉树;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _654_最大二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
          val = x;
        }
    }

    /**
     * 普通二叉树递归遍历解决
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {

        if (l == r) {
            return null;
        }
        // 找出[l,r)范围的最大值对应的索引
        int maxIndex = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        // 返回的是一个new的节点
        root.left = findRoot(nums, l, maxIndex);
        root.right = findRoot(nums, maxIndex + 1, r);
        return root;
    }
}
