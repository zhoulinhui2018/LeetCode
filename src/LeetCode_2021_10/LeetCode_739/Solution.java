package LeetCode_2021_10.LeetCode_739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/20
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        int[] right = new int[length];
        Arrays.fill(right,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < right.length; i++) {
            int t = T[i];
            while (!stack.isEmpty()&&T[stack.peekLast()] < t){
                right[stack.pollLast()] = i;
            }
            stack.offer(i);
        }
        for (int i = 0; i < length; i++) {
            if (right[i]!=-1){
                ans[i] = right[i] - i;
            }
        }
        return ans;
    }
}
