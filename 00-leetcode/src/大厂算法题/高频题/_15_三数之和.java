package 大厂算法题.高频题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/3sum/
 * @author rnang0
 * @date 2020/8/7
 */
class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            map.put(nums[0],0);
            for (int j = i + 1; j < length; j++) {
                int complement = -nums[i] - nums[j];
                if (map.containsKey(complement)) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(complement);
                    resultList.add(list);
                }
                map.put(nums[j],j);
            }
        }
        throw new IllegalArgumentException("No three sum solution");
    }
}
