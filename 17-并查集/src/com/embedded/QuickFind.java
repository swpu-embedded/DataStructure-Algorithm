package com.embedded;

/**
 * QuickFind思想实现并查集，数组里存储parent
 * find：O（1）
 * union：O（n）
 * @author rnang0
 * @date 2020/8/20
 **/
public class QuickFind extends AbstractUnionFind{

    public QuickFind(int capacity) {
        super(capacity);
    }

    /**
     * 父节点即可
     * @param v
     * @return
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * v1跟随v2，且v1集合所有元素也要跟随v2
     * 其实不符合逻辑，所以采用QuickUnion实现
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) {
            return;
        }

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
}
