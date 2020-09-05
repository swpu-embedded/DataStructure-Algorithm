package 大厂算法题.数组_排序;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author rnang0
 * @date 2020/9/5
 **/
public class _977_有序数组的平方 {
    /**
     * 直接利用三指针，从两头向中间，免去寻找中间正负拐点
     * 其中一个指针越界了，即负变正，或者正变负了
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        if (A.length == 1) {
            return new int[] {(int) Math.pow(A[0], 2)};
        }
        int[] array = new int[A.length];
        int head = 0;
        int tail = A.length - 1;
        // cur是操作结果数组的，由于升序所以大的先放后面
        //[-4,-1,0,3,10]
        int cur = tail;

        while (A[head] <= 0 && A[tail] > 0) {
            if (Math.abs(A[head]) >= Math.abs(A[tail])) {
                array[cur--] = A[head] * A[head];
                head++;
            } else {
                array[cur--] = A[tail] * A[tail];
                tail--;
            }
        }
        // 其中一个指针越界了，即负变正，或者正变负了
        // 就只需要从一端到另一端扫描输出即可
        if (A[head] > 0) {
            while (head <= tail) {
                array[cur--] = A[tail] * A[tail];
                tail--;
            }
            return array;
        }
        if (A[tail] <= 0) {
            while (head <= tail) {
                array[cur--] = A[head] * A[head];
                head++;
            }
        }
        return array;
    }
}
