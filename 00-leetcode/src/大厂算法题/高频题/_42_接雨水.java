package 大厂算法题.高频题;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author rnang0
 * @date 2020/11/21
 **/
public class _42_接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // 某索引位置左右最大的高度，迭代求
        int[] leftIndexes = new int[height.length];
        int[] rightIndexes = new int[height.length];

        // 从左到右扫描，求左边最大
        int leftMax = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] >= leftMax) {
                leftIndexes[i] = height[i - 1];
                leftMax = height[i - 1];
            } else {
                leftIndexes[i] = leftMax;
            }
        }
        // 从右到左扫描，求右边最大
        int rightMax = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] >= rightMax) {
                rightIndexes[i] = height[i + 1];
                rightMax = height[i + 1];
            } else {
                rightIndexes[i] = rightMax;
            }
        }

        // 计算雨水的高度
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int high = Math.min(leftIndexes[i], rightIndexes[i]) - height[i];
            if (high > 0) {
                water += high;
            }
        }
        return water;
    }
}
