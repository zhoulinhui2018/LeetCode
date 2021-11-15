package LeetCode_2021_03.Leetcode_84;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            int cur = heights[i];
            while (!stack.isEmpty()&&heights[stack.peekLast()]>=cur){
                right[stack.peekLast()]=i;
                stack.pollLast();
            }
            left[i]=stack.isEmpty()?-1:stack.peekLast();
            stack.offer(i);
        }
        int ans=0;
        for (int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(right[i]-left[i]-1));
        }
        return ans;
    }
}
