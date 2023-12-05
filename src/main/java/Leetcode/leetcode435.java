package Leetcode;
import java.util.*;
public class leetcode435 {
    public static void main(String[] args) {
        int[][] intervals = {{2,12}, {11, 12}, {1, 100}, {1, 11}};
        System.out.print(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            return Integer.compare(a[1],b[1]);
        });
        int len = intervals.length;
        int count = 1;
        int min = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (min <= intervals[i][0]) {
                count++;
                min = intervals[i][1];
            }
        }
        return len - count;
    }
}
