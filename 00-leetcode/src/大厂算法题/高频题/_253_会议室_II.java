package 大厂算法题.高频题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/meeting-rooms-ii/
 * @author rnang0
 * @date 2020/11/21
 **/
public class _253_会议室_II {
    /**
     * 利用最小堆来解决
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] m1, int[] m2) {
                return m1[0] - m2[0];
            }
        });

        // 创建一个最小堆(优先队列)
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.remove();
            }
            heap.add(intervals[i][1]);
        }

        return heap.size();
    }

    /**
     * 分开排序，将开始时间和结束时间分开排序
     * @param intervals
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 分开排序，将开始时间和结束时间分开排序
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int meetingRooms = 0;
        int endIndex = 0;
        for (int value : begin) {
            if (value < end[endIndex]) {
                meetingRooms++;
            } else {
                endIndex++;
            }
        }
        return meetingRooms;
    }
}
