package com.embedded.sorting.cmpare;

/**
 * 冒泡排序优化算法
 * @author rnang0
 * @date 2020/8/18
 **/
public class BubbleSort<E extends Comparable<E>> extends AbstractCompareSort<E> {

    /**
     * 冒泡排序优化算法，稳定、原地的排序算法
     */
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            // 加入endIndex记录最后一次交换位置
            // 初始值为完全有序时的下标为，即1
            int endIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin,begin - 1) < 0) {
                    swap(begin,begin - 1);
                    // 记录交换位置
                    endIndex = begin;
                }
            }
            end = endIndex;
        }
        print();
    }
}
