package com.embedded;

/**
 * QuickUnion优化算法-基于Rank优化 + 路径压缩
 * @author rnang0
 * @date 2020/8/20
 **/
public class QuickUnionByRankPathCompression extends QuickUnion{

    public QuickUnionByRankPathCompression(int capacity) {
        super(capacity);
    }

    /**
     * 路径压缩优化
     * 做法：在find时，修改路径上所有节点根结点=最后的根结点，从而降低树高
     * 缺点：树高度降低离谱，但是成本很高，每个节点都要压缩
     *      1. 路径分裂：所以就使每个节点指向祖父即可了
     *      2. 路径减半：跳一个节点才指向祖父节点
     * @param v
     * @return
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        /*1. 路径压缩：修改路径上所有节点根结点=最后的根结点*/
//        if (v != parents[v]) {
//            // 递归返回时，返回最后的根结点 return v;
//            // 则所有的路径节点指向最后的根结点
//            parents[v] = find(parents[v]);
//        }
//        return v;
        /*2. 路径分裂：使每个节点指向祖父即可*/
//        if (v != parents[v]) {
//            int parent = parents[v];
//            parents[v] = parents[parent];
//            v = parent;
//        }
//        return v;
        /*3. 路径减半：跳一个节点指向祖父节点，中间的依然只指向父亲不动*/
        if (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }

}
