package com.embedded;

import com.embedded.sorting.space.BucketSort;
import com.embedded.sorting.space.CountingSort;
import com.embedded.sorting.space.RadixSort;

/**
 * 排序测试
 * @author rnang0
 * @date 2020/8/18
 **/
public class Main {

    private static final Integer[] ARRAY = {3, 2, 30, 1, 23, 33 ,34, 35, 66, 77};

    private static final Double[] DOUBLE_ARRAY = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.76};

    public static void main(String[] args) {
        Integer[] array = ARRAY;
        Double[] doubleArray = DOUBLE_ARRAY;
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

        // 6. 快速排序
        //QuickSort<Integer> quickSort = new QuickSort<>();
        //quickSort.sort(array);

        // 7. 希尔排序
        //ShellSort<Integer> shellSort = new ShellSort<>();
        //shellSort.sort(array);

        // 8. 计数排序
        //CountingSort countingSort = new CountingSort();
        //countingSort.sort(array);

        // 9. 基数排序
        //RadixSort radixSort = new RadixSort();
        //radixSort.sort(array);

        //10. 桶排序
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(doubleArray);
    }

}
