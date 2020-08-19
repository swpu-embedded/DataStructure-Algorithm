package com.embedded.sorting;

/**
 * 归并排序算法
 * @author rnang0
 * @date 2020/8/19
 **/
public class MergeSort<E extends Comparable<E>> extends AbstractSort<E> {

    /**
     * 左边序列的数组
     */
    private E[] leftArray;

    /**
     * 归并排序算法，稳定的、非原地的排序（申请了左边数组）
     */
    @Override
    protected void sort() {
        // 新建左边序列的数组来备份数据
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0,array.length);
        print();
    }

    /**
     * 对[begin,end)范围进行递归的归并排序
     * 归并排序总是平均分割子序列
     * 时间复杂度 = 2 * T(n / 2) + O（n） = O(nlogn)
     * 空间复杂度 = O（n）
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        int mid = (begin + end) >> 1;
        // [begin,mid)
        sort(begin,mid);
        // [mid,end)
        sort(mid,end);

        merge(begin,mid,end);
    }

    /**
     * 对[begin,mid) 和 [mid,end) 合并为一个有序序列
     * 这两个序列挨在一起
     * @param begin
     * @param mid
     * @param end
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        // 避免重复创建，则在外部创建大小足够保证
        for (int i = li; i < le; i++) {
            // 重点：左边序列起始是begin + i
            leftArray[i] = array[begin + i];
        }

        // 左边还没结束
        while (li < le) {
            // 保证稳定性，且ri = re了，即左边全部挪过去
            if (ri < re && cmp(leftArray[li], array[ri]) > 0) {
                array[ai] = array[ri];
                ai++;
                ri++;

            } else {
                array[ai] = leftArray[li];
                ai++;
                li++;
            }
        }
    }

}
