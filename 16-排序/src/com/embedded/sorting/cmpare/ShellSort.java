package com.embedded.sorting.cmpare;

import java.util.ArrayList;
import java.util.List;

/**
 * 希尔排序算法
 * @author rnang0
 * @date 2020/8/20
 **/
public class ShellSort<E extends Comparable<E>> extends AbstractCompareSort<E> {

    /**
     * 希尔排序是不稳定的（逐列排序，可能把后面的放到前面去）、原地的排序
     * 每列由于逆序对很少，即进行插入排序
     * 时间复杂度：取决于步长序列
     */
    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
        print();
    }

    /**
     * 生成步长序列
     * @return
     */
    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;

        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

    /**
     * step列进行排序
     * @param step
     */
    private void sort(int step) {
        // 单独对第col列进行排序
        for (int col = 0; col < step; col++) {
            // 每列进行插入排序
            // col、col+step、col+2*step、col+3*step
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - 1) < 0) {
                    // 向上一列进行比较交换
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }
}
