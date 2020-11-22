package 大厂算法题.高频题;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @author rnang0
 * @date 2020/11/17
 **/
public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 上面从左往右扫
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // 右边从上往下扫
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // 这里可能会多执行,则判断一下条件
            if (top > bottom || left > right) {
                break;
            }

            // 下边从右往左扫
            for (int i = right; i >= left ; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            // 左边从下往上扫
            for (int i = bottom; i >= top ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
