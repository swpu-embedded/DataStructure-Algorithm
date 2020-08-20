package com.embedded.sorting.space;

import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序（拓展）
 * @author rnang0
 * @date 2020/8/20
 **/
public class BucketSort extends AbstractSpaceSort<Double>{

    @Override
    protected void sort() {
        // 桶数组，单个桶是个链表
        List<Double>[] buckets = new List[array.length];

        // 每个元素放入对应桶（依次递增，桶内无序）
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (int)(array[i] * array.length);

            List<Double> bucket = buckets[bucketIndex];
            // 当该位置没有桶创建（第一个元素进来），新建链表
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(array[i]);
        }

        // 对每个桶进行排序
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            }
            buckets[i].sort(null);
            for (Double num : buckets[i]) {
                array[index] = num;
                index++;
            }
        }
        print();
    }
}
