package com.embedded.sorting.space;

/**
 * 计数排序优化算法（扩展）
 * @author rnang0
 * @date 2020/8/20
 **/
public class CountingSort extends AbstractSpaceSort<Integer> {

    /**
     * 计数排序，对一定范围内的整数进行排序，且不是稳定排序
     */
    protected void sort1() {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // max要作为索引，所以需要max + 1这么多空间
        int[] countsArray = new int[max + 1];

        for (int i = 0; i < array.length; i++) {
            // array[i]是整数，则将其作为countsArray的索引
            countsArray[array[i]]++;
        }

        // 根据出现次数，进行排序到原先的array数组中输出
        int index = 0;
        for (int i = 0; i < countsArray.length; i++) {
            while (countsArray[i]-- > 0) {
                array[index] = i;
                index++;
            }
        }

        print();
    }

    /**
     * 计数排序优化，索引下标不为0开始，稳定的
     * 时间复杂度：4*O（n） + 2*O（k）= O（n + k）
     * 空间复杂度：O（n + k）
     */
    @Override
    protected void sort() {
        // 找出最大/最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        int[] countsArray = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            // array[i] - min 才是对应索引，不是从零开始
            countsArray[array[i] - min]++;
        }

        // countsArray存放前面的值累加起来
        for (int i = 1; i < countsArray.length; i++) {
            // array[i] - min 才是对应索引，不是从零开始
            countsArray[i] += countsArray[i - 1];
        }

        // 从后往前遍历元素，放到有序数组中的位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0 ; i--) {
            // 依次拿取数据
            newArray[--countsArray[array[i] - min]] = array[i];
        }

        //newArray赋值给array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }

        print();
    }
}
