package com.embedded;

/**
 * 并查集：解决连接类的问题
 * @author rnang0
 * @date 2020/8/20
 **/
public abstract class AbstractUnionFind {

    protected int[] parents;

    public AbstractUnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }

        parents = new int[capacity];

        // 初始化
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     * 查找v所属的集合（最终根结点）
     * @param v
     * @return
     */
    public abstract int find(int v);

    /**
     * 合并v1，v2所属的集合
     * @param v1
     * @param v2
     */
    public abstract void union(int v1, int v2);

    /**
     * 检测v1，v2是否属于同一集合（最终根结点）
     * @param v1
     * @param v2
     * @return
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }


}
