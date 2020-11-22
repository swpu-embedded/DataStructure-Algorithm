package 大厂算法题.高频题;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 * @author rnang0
 * @date 2020/8/7
 */
class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);

        int lastIndex = nums.length - 3;
        for (int i = 0; i <= lastIndex; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    resultList.add(list);
                    // 如果同时相减，可以会有重复结果，则需要去重复
                    // 例如：[-2,0,0,2,2]
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < -nums[i]) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        return resultList;
    }
}
