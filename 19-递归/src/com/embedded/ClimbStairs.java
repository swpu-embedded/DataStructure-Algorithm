package com.embedded;

/**
 * 爬楼梯递归问题
 * @author rnang0
 * @date 2020/8/22
 */
public class ClimbStairs {
	
	int climbStairs(int n) {
		if (n <= 2) return n;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
}
