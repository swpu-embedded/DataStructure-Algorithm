package com.embedded.sorting.cmpare;

/**
 * 基于比较的排序，平均时间复杂度最低O（nlogn）
 * @author rnang0
 * @date 2020/8/18
 **/
public abstract class AbstractCompareSort<E extends Comparable<E>> {
    protected E[] array;

    private int cmpCount;

    private int swapCount;

    public void sort(E[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        this.array = array;
        sort();
    }

    protected abstract void sort();

    /**
     * 返回值代表大于等于关系
     * @param i1
     * @param i2
     * @return
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }


    protected int cmp(E i1, E i2) {
        cmpCount++;
        return i1.compareTo(i2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        E temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    protected void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("_" + array[i] + "_");
        }
    }
}
