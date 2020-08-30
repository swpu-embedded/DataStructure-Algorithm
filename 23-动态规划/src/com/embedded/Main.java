package com.embedded;

import com.embedded.dp.*;

/**
 * @author rnang0
 * @date 2020/8/27
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(CoinChange.coins5(41, new int[] {1, 5, 20, 25}));
        System.out.println(MaxSubarray.maxSubarray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(LengthOfLIS.lengthOfLIS(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
        System.out.println(LengthOfLCS.longestCommonSubsequence(
                new int[] {1, 3, 5, 9, 10},
                new int[] {1, 4, 9, 10}));
        System.out.println(LengthOfLCS.longestCommonSubsequence1(
                new int[] {1, 3, 5, 9, 10},
                new int[] {1, 4, 9, 10}));
        System.out.println(LengthOfLCSubstring.lcSubstring("ABCBA", "BABCA"));

    }
}
