package com.embedded;

/**
 * QuickUnion优化算法（推荐）
 * find和union都是O（logn）
 * @author rnang0
 * @date 2020/8/20
 **/
public class QuickUnion extends AbstractUnionFind{

    //private int[] sizes;

    private int[] ranks;

    public QuickUnion(int capacity) {
        super(capacity);
        /*------1. 基于size优化sizes[i]对应每个节点对应树的大小---------*/
//        sizes = new int[capacity];
//        for (int i = 0; i < sizes.length; i++) {
//            sizes[i] = 1;
//        }
        /*------2. 基于rank优化ranks[i]对应每个节点对应树的高度---------*/
        ranks = new int[capacity];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1;
        }
    }

    /**
     * 寻找根结点
     * @param v
     * @return
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    /**
     * v1的根结点跟随v2的根结点
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
        /*1. 基于size优化，size小的跟随size大的，降低树高度---------*/
//        if (sizes[p1] < sizes[p2]) {
//            // v2的根结点赋值给v1的根结点
//            parents[p1] = p2;
//            sizes[p2] += sizes[p1];
//        } else {
//            // v1的根结点赋值给v2的根结点
//            parents[p2] = p1;
//            sizes[p1] += sizes[p2];
//        }
        /*2. 基于rank的优化（树的高度）,rank小的跟随rank大的，降低树高度*/
        if (ranks[p1] < ranks[p2]) {
            // v2的根结点赋值给v1的根结点
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]){
            // v1的根结点赋值给v2的根结点
            parents[p2] = p1;
        } else {
            // 随便选个，然后被指向的要加一层高度
            parents[p1] = p2;
            ranks[p2]++;
        }
        /*3. 路径压缩，在find时，使路径上所有节点最后都指向根结点，从而降低树高*/
    }
}
