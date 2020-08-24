package com.embedded;

/**
 * 物品类
 * @author rnang0
 * @date 2020/8/24
 */
public class Article {
	public int weight;
	public int value;
	public double valueDensity;
	public Article(int weight, int value) {
		this.weight = weight;
		this.value = value;
		valueDensity = value * 1.0 / weight;
	}
	@Override
	public String toString() {
		return "Article [weight=" + weight + ", value=" + value + ", valueDensity=" + valueDensity + "]";
	}
}
