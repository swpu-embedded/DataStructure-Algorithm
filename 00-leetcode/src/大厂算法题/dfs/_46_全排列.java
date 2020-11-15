package 大厂算法题.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * @author rnang0
 * @date 2020/11/11
 **/
public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        // 每个结果数组
        int[] result = new int[nums.length];
        // 记录是否用过，来使得不重复
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, list, result, used);
        return list;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> list, int[] result, boolean[] used) {
        if (index == nums.length) {
            // 把result数组加入到list中
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 由于不能重复，判断一下是否用过
            if (used[i]) continue;
            result[index] = nums[i];
            used[i] = true;
            dfs(index + 1, nums, list, result, used);
            // 返回上一级，需要将此used复原，其他位置才能使用该值
            used[i] = false;
        }

    }

    /**
     * 不使用额外的result
     * 使用覆盖nums来实现，天然的解决了下一层不能使用上一层选过值的问题
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
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
            swap(nums, i, index);
            dfs1(index + 1, nums, list);
            //每次dfs返回后，需恢复现场
            swap(nums, i, index);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
