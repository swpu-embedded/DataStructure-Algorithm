package 大厂算法题.数组_排序;


/**
 * https://leetcode-cn.com/problems/sort-colors/
 * @author rnang0
 * @date 2020/9/5
 **/
public class _75_颜色分类 {

    /**
     * 一个包含0、1和2，原地且一趟对它们进行排序
     * 一般一趟就要进行排序的情况，通常我们就需要使用双指针，甚至三指针
     * 这种有0、1或者正负这种大小顺序的、或者是0,1,2、正负0这种的，可以使用头尾两个指针来将小的放一边，大的放一边
     * @param nums
     */
    public void sortColors(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int cur = head;
        int temp = 0;
        // cur等于tail时
        while (cur <= tail) {
            if (nums[cur] == 0) {
                swap(nums, cur, head);
                // 此时前面只能是0,1所以不需要再进行判断是否为2
                head++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, tail);
                tail--;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
