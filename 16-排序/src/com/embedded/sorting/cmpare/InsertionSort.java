package com.embedded.sorting.cmpare;

/**
 * 插入排序优化算法
 * @author rnang0
 * @date 2020/8/19
 **/
public class InsertionSort<E extends Comparable<E>> extends AbstractCompareSort<E> {

    /**
     * 插入排序，稳定的、原地的排序算法，时间复杂度与逆序对个数成正比，因为要找位置
     * 优化：
     * （1）所以就先将数据备份，挪动前面的元素
     * （2）二分搜索优化，优化了比较次数，挪动还是要挪动，还是O（n^2）
     */
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            // int cur = begin;
            // 数据备份
            E element = array[begin];
//            while (cur > 0 && cmp(cur, cur - 1) < 0) {
//                // 1.交换
//                //swap(cur, cur - 1);
//
//                // 2.将交换改为挪动
//                array[cur] = array[cur - 1];
//                // cur减一之后为begin所在的值，依次比较然后插入
//                cur--;
//
//            }
//            array[cur] = element;

            // 3.采用二分搜索进行插入优化
            int insertIndex = search(begin);
            for (int i = begin - 1; i >= insertIndex; i--) {
                array[i + 1] = array[i];
            }
            array[insertIndex] = element;
        }
        print();
    }

    private int search(int index) {
        E element = array[index];

        int begin = 0;
        int end = index;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            // 明确我们目标是找第一个比element大的值的位置
            if (cmp(element,array[mid]) < 0) {
                end = mid;
            } else {
                // element >= array[mid]
                // 相等时仍然往右搜索，找第一个比它大的位置
                begin = mid + 1;
            }
        }
        // begin == end处即为我们插入位置（第一个比element大的值的位置）
        return begin;
    }
}
