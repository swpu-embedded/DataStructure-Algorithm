package com.embedded;

import com.embedded.sorting.*;

/**
 * 排序测试
 * @author rnang0
 * @date 2020/8/18
 **/
public class Main {

    private static final Integer[] ARRAY = {3, 2, 30, 1, 23, 33 ,34, 35, 66, 77};

    public static void main(String[] args) {
        Integer[] array = ARRAY;
        // 1. 使用冒泡排序
        //BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        //bubbleSort.sort(array);

        // 2. 使用选择排序
        //SelectionSort<Integer> selectionSort = new SelectionSort<>();
        //selectionSort.sort(array);

        // 3. 选择堆排序
        //HeapSort<Integer> heapSort = new HeapSort<>();
        //heapSort.sort(array);

        // 4. 插入排序
        //InsertionSort<Integer> insertionSort = new InsertionSort<>();
        //insertionSort.sort(array);

        // 5. 归并排序
        //MergeSort<Integer> mergeSort = new MergeSort<>();
        //mergeSort.sort(array);
    }

}
