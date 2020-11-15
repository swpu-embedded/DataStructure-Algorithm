package 大厂算法题.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author rnang0
 * @date 2020/11/11
 **/
public class _47_全排列II {
    /**
     * 不使用额外的result
     * 使用覆盖nums来实现，天然的解决了下一层不能使用上一层选过值的问题
     * 有重复数字
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        dfs1(0, nums, list);
        return list;
    }

    private void dfs1(int index, int[] nums, List<List<Integer>> list) {
        if (index == nums.length) {
            // 结果是要返回List<List>
            List<Integer> resultList = new ArrayList<>();
            for (int value : nums) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // i从index开始，index位置与i进行交换
            // 保证index位置，每个值只出现一次，因为出现相同后面的组合是一样的，叶子重复
            if (isEqual(nums, index, i)) {
                continue;
            }
            swap(nums, i, index);
            dfs1(index + 1, nums, list);
            //每次dfs返回后，需恢复现场
            swap(nums, i, index);
        }

    }

    private boolean isEqual(int[] nums, int index, int i) {
        for (int j = index; j < i; j++) {
            // index到i区间出现过与num[i]相同的值，就不用交换，因为前面换过
            // 前面换过所以叶子的排列组合是一样的
            if (nums[j] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
