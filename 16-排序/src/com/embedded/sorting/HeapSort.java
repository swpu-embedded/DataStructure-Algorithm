package com.embedded.sorting;


/**
 * 堆排序算法
 * @author rnang0
 * @date 2020/8/18
 **/
public class HeapSort<E extends Comparable<E>> extends AbstractSort<E> {

    private int heapSize;

    /**
     * 堆排序，可以认为是选择排序优化（挑选最值）
     * 不是稳定、原地的排序
     */
	@Override
	protected void sort() {
		// 原地建堆
		heapSize = array.length;
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}

		while (heapSize > 1) {
			// 交换堆顶元素和尾部元素
			swap(0, --heapSize);

			// 对0位置进行siftDown（恢复堆的性质）
			siftDown(0);
		}
		print();
	}

	/**
     * 让某一个位置节点下滤
     * @param index
     */
    private void siftDown(int index) {
        E element = array[index];
        int halfIndex = heapSize >> 1;
        // index要小于第一个叶子节点的索引
        while (index < halfIndex) {
            // 左子节点
            int childIndex = (index << 1) + 1;
            E childElement = array[childIndex];

            // 判定是否有右节点，且比较左节点值，选最大值
            int rightIndex = childIndex + 1;
            if (rightIndex < heapSize && cmp(array[rightIndex],childElement) > 0) {
                childElement = array[childIndex = rightIndex];
            }
            if (cmp(element,childElement) >= 0) {
                break;
            }
            array[index] = childElement;
            index = childIndex;
        }
        array[index] = element;
    }

}
