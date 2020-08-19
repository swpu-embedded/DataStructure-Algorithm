package com.embedded.sorting;

/**
 * 选择排序算法
 * @author rnang0
 * @date 2020/8/18
 **/
public class SelectionSort<E extends Comparable<E>> extends AbstractSort<E> {

    /**
     * 选择排序算法，稳定、原地的排序算法
     * 交换次数少于冒泡（一轮才一次，选最大/小），但最好情况也是O（n^2）
     */
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0 ; end--) {
            // 假定第一位是最大的元素
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin,maxIndex) > 0) {
                    maxIndex = begin;
                }
            }
            // 最值放到end处
            swap(maxIndex,end);
        }
        print();
    }
}
