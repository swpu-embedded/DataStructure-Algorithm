package 大厂算法题.数组_排序;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * @author rnang0
 * @date 2020/9/5
 **/
public class _面试题_16_16_部分排序 {

    /**
     * 找出排好序后整个数组有序的最短序列
     * 本质就是不断的扫描找出最后一个逆序对（比前面小），和最前面一个逆序对（比后面大）
     * @param array
     * @return
     */
    public int[] subSort(int[] array) {
        int length = array.length;
        if (length == 0) {
            return new int[] {-1, -1};
        }

        int max = array[0];
        int min = array[length - 1];
        int flagHead = -1;
        int flagTail = -1;
        // 1.从左到右寻找最后一个比前面小的位置
        for (int i = 1; i < length; i++) {
            int j = length - 1 - i;
            if (array[i] >= max) {
                max = array[i];
            } else {
                flagTail = i;
            }
            // 2.从右到左寻找最后一个比后面大的位置
            if (array[j] <= min) {
                min = array[j];
            } else {
                flagHead = j;
            }
        }
        return new int[] {flagHead, flagTail};
    }
}
