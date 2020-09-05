package 大厂算法题.数组_排序;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author rnang0
 * @date 2020/9/5
 **/
public class _88_合并两个有序数组 {
    /**
     * 升序排列的两个数组
     * 可以额外开辟一个大小为nums1.length的数组空间，然后选择从小到大输出
     * 优化：直接可以使用三个指针，分别从后往前遍历
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        // 从后往前遍历，大的值就放到后面即（cur处），因为是从后往前遍历，所以开始拿到的肯定是比较大的
        // 所以直接放在后面cur处即可
        int cur = nums1.length - 1;

        while (n1 != -1 && n2 != -1) {
            if (nums1[n1] > nums2[n2]) {
                nums1[cur] = nums1[n1];
                n1--;
            } else {
                nums1[cur] = nums2[n2];
                n2--;
            }
            cur--;
        }

        // nums1提前结束，则nums2放入
        if (n1 == -1) {
            while(cur != -1) {
                nums1[cur] = nums2[n2];
                n2--;
                cur--;
            }
        }
    }
}
