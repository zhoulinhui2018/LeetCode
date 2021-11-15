package LeetCode_2021_03.Leetcode_739;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] right = new int[T.length];
        Arrays.fill(right,T.length);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            while (!stack.isEmpty()&&T[stack.peekLast()]<=temp){
                right[stack.peekLast()]=i;
                stack.pollLast();
            }
            stack.offer(i);
        }
        for (int i=0;i<T.length;i++){
            if (right[i]!=T.length){
                ans[i]=right[i]-i;
            }
        }
        return ans;
    }
}
