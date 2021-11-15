package LeetCode_2021_03.Leetcode_435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));
        int ans = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                ans++;
                end = interval[1];
            }
        }
        return intervals.length - ans;
    }


}
