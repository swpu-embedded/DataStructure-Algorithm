package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author rnang0
 * @date 2020/11/16
 **/
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        // j指向第一个0位置，初始在头
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
