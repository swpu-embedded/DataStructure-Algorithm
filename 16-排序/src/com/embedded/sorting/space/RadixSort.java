package com.embedded.sorting.space;

/**
 * 基数排序，适用于非负整数的排序（扩展）
 * @author rnang0
 * @date 2020/8/20
 **/
public class RadixSort extends AbstractSpaceSort<Integer> {

    /**
     * 依次对个位、十位、百位、千位。。。。进行排序
     */
    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int digit = (int)Math.log(max) + 1;
        int divider = 1;
        for (int i = 0; i < digit; i++) {
            countingSort(divider);
            divider *= 10;
        }
        print();
    }

    private void countingSort(int divider) {
        // 每一位都是 0 - 9
        int[] countsArray = new int[10];

        for (int i = 0; i < array.length; i++) {
            // array[i] - min 才是对应索引，不是从零开始
            countsArray[array[i] / divider % 10]++;
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
            newArray[--countsArray[array[i] / divider % 10]] = array[i];
        }

        //newArray赋值给array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }
}
