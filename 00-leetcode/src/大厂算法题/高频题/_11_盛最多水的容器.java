package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author rnang0
 * @date 2020/11/21
 **/
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int water = 0;
        // 双指针，往里面遍历
        int l = 0, r = height.length - 1;
        int high = 0;

        while (l < r) {
            // 找最短的线，只需从短线往里搜
            if (height[l] >= height[r]) {
                high = height[r];
                // 跟上次的面积比较
                water = Math.max((r - l) * high, water);
                // 往里搜，更短的或者相等的就跳过
                while (l < r && height[r] <= high) {
                    r--;
                }
            } else {
                high = height[l];
                // 跟上次的面积比较
                water = Math.max((r - l) * high, water);
                // 往里搜，更短的或者相等的就跳过
                while (l < r && height[l] <= high) {
                    l++;
                }
            }
        }
        return water;
    }
}
