package com.embedded.sorting.space;

/**
 * 扩展排序：
 * 利用空间换时间的排序
 * @author rnang0
 * @date 2020/8/20
 **/
public abstract class AbstractSpaceSort<E> {

    protected E[] array;

    public void sort(E[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        this.array = array;
        sort();
    }

    protected abstract void sort();

    protected void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("_" + array[i] + "_");
        }
    }
}
