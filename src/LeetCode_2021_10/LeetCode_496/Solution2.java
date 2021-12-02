package LeetCode_2021_10.LeetCode_496;

import java.util.*;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/20
 */
public class Solution2 {
    public List<int[]> getNextGreater(int[] nums) {
        int length = nums.length;
        int[] right = new int[length];
        int[] left = new int[length];
        Arrays.fill(right, length);
        Arrays.fill(left, length);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < right.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] >= num) {
                right[stack.pollLast()] = i;
            }
            left[i] = stack.isEmpty()?-1:stack.peekLast();
            stack.offer(i);
        }
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(left);
        ans.add(right);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        Solution2 solution2 = new Solution2();
        List<int[]> nextGreater = solution2.getNextGreater(arr);
        System.out.println(Arrays.toString(nextGreater.get(0)));
        System.out.println(Arrays.toString(nextGreater.get(1)));
    }
}
