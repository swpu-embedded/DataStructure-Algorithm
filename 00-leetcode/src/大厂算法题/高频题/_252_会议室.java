package 大厂算法题.高频题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 * @author rnang0
 * @date 2020/11/18
 **/
public class _252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        // 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] m1, int[] m2) {
                return m1[0] - m2[0];
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
