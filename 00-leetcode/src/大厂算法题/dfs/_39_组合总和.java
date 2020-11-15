package 大厂算法题.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * @author rnang0
 * @date 2020/11/15
 **/
public class _39_组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 返回null，根据leetcode判题结果得出
        if (candidates == null || candidates.length == 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(0, target, candidates, result, list);
        return list;
    }

    private void dfs(int index, int target, int[] candidates, List<Integer> result, List<List<Integer>> list) {
        // 这里就不是进入最后一层了，是target减为0
        if (target == 0) {
            list.add(new ArrayList<>(result));
            return;
        }

        // 注意这里，每次取都是从index开始，每次加1
        for (int i = index; i < candidates.length; i++) {
            // 数比较大，没必要加了
            if (candidates[i] > target) {
                return;
            }

            result.add(candidates[i]);
            dfs(i, target - candidates[i], candidates, result, list);
            // 还原
            result.remove(result.size() - 1);
        }
    }
}
