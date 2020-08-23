package com.embedded;

/**
 * N皇后优化——位运算
 * @author rnang0
 * @date 2020/8/23
 **/
public class QueenByDigit {

    int n;

    /**
     * 皇后在某一行摆放的列号
     * 数组索引是行号，值为列号，便于打印n皇后摆放
     */
    int[] queens;

    /**
     * 标记所有列是否摆放皇后
     * 采用位运算优化，8位二进制数 = byte
     */
    byte cols;

    /**
     * 标记所有主对角线是否摆放皇后
     * leftTop[1] = true，则第一条对角线是否摆放皇后
     */
    short leftTop;

    /**
     * 标记所有副对角线是否摆放皇后
     * rightTop[1] = true，则第一条对角线是否摆放皇后
     */
    short rightTop;

    int ways;

    public QueenByDigit(int n) {
        this.n = n;
    }

    public void placeQueens() {
        if (n < 1) {
            return;
        }
        // 初始化标记数组
        queens = new int[n];

        // 从第零行开始摆放皇后
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 回溯 + 剪枝
     * 从第row行开始摆放皇后
     * @param row
     */
    private void place(int row) {
        if (row == n) {
            ways++;
            print();
            return;
        }

        for (int col = 0; col < n; col++) {
            // 剪枝，如果判断不在该列，不在对角线，可以摆
            if ((cols & (1 << col)) != 0) {
                continue;
            }
            // 通过行和列计算，所在对角线索引leftIndex 和 rightIndex
            int leftIndex = n - 1 - col + row;
            int rightIndex = row + col;
            if ((leftTop & (1 << leftIndex)) != 0 ||
                    (rightTop & (1 << rightIndex)) != 0) {
                continue;
            }

            // 在第row行第col列摆放皇后
            queens[row] = col;
            cols = (byte)(cols | (1 << col));
            leftTop = (byte)(leftTop | (1 << leftIndex));
            rightTop = (byte)(rightTop | (1 << rightIndex));

            // 继续下一行
            place(row + 1);

            // 该行所有都不满足，place（该行）执行完毕，回溯到上一行
            // 刚刚标记的需要重制
            // 01111101 n
		    //&11111011  ~00000100
		    // 01111001
            cols = (byte)(cols & ~(1 << col));
            leftTop = (byte)(leftTop & ~(1 << leftIndex));
            rightTop = (byte)(rightTop & ~(1 << rightIndex));
        }

    }
    /**
     * 打印n皇后
     */
    private void print() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
