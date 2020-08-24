package com.embedded;

import java.util.Arrays;

/**
 * 海盗问题
 * @author rnang0
 * @date 2020/8/24
 **/
public class Pirate {
    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);

        int Capacity = 30;
        int weight = 0, count = 0;

        for (int i = 0; i < weights.length && weight < Capacity; i++) {
            int newWeight = weights[i] + weight;

            if (newWeight <= Capacity) {
                weight = newWeight;
                count++;
            }
        }

        System.out.println("选了" + count + "件古董");
    }
}
