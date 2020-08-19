package com.embedded.search;

/**
 * 二分查找
 * @author rnang0
 * @date 2020/8/19
 **/
public class BinarySearch {

    /**
     * 二分查找，有则返回索引
     * @param array 有序数组array
     * @param element 查找值
     * @return
     * -1 无结果，数据有误
     * 非-1，则返回索引位置
     */
    public static int indexOf(int[] array, int element) {
        if (array == null || array.length == 0) {
            return -1;
        }

        // 下标原则，左闭右开
        int begin = 0;
        // end为最后一个元素加1
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;

            if (element < array[mid]) {
                end = mid;
            } else if (element > array[mid]) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分搜索，查找element在有序数组array待插入的位置
     * @param array 有序数组array
     * @param element 查找值
     * @return 第一个比element大的值的位置
     */
    public static int search(int[] array, int element) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            // 明确我们目标是找第一个比element大的值的位置
            if (element < array[mid]) {
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
