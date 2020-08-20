package com.embedded.sorting.cmpare;

/**
 * 快速排序优化算法
 * @author rnang0
 * @date 2020/8/19
 **/
public class QuickSort<E extends Comparable<E>> extends AbstractCompareSort<E> {

    /**
     * 快速排序算法，不稳定的，原地的排序
     * 时间复杂度：最好情况O（nlogn），最坏O（n^2），避免出现最坏情况进行优化方案
     * 空间复杂度：由于递归调用，而外开辟栈空间，则复杂度为O（logn）
     */
    @Override
    protected void sort() {
        sort(0,array.length);
        print();
    }

    /**
     * 对区间[begin,end)范围的元素进行快速排序
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        // 确定轴点array[begin]位置O（n）
        int pivotIndex = pivotIndex(begin,end);

        // 对轴点两边的子序列快排，所以右边是pivotIndex + 1
        sort(begin,pivotIndex);
        sort(pivotIndex + 1,end);
    }

    /**
     * 确定[begin,end)范围的轴点pivot位置
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int begin, int end) {
        // 避免出现最坏情况进行优化方案：
        // 随机选取一个值与begin位置替换，作为轴点
        int length = end - begin;
        swap(begin,begin + (int) (Math.random() * length));

        // 备份轴点元素
        E pivot = array[begin];
        end--;

        // 改变方向的标志，等于一概放到另外一边，平均分配提高效率
        boolean isLeft = false;
        while (begin < end) {
            if (!isLeft) {
                if (cmp(array[end],pivot) > 0) {
                    end--;
                } else {
                    // 覆盖再加加
                    array[begin] = array[end];
                    begin++;
                    isLeft = true;
                }
            } else {
                if (cmp(array[begin],pivot) < 0) {
                    begin++;
                } else {
                    array[end] = array[begin];
                    end--;
                    isLeft = false;
                }
            }
        }
        array[begin] = pivot;
        return begin;
    }
}
