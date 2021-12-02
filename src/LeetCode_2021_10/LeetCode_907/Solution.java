package LeetCode_2021_10.LeetCode_907;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/20
 */
public class Solution {
    private static final int MOD = 1000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int[] left = getLastSmaller(arr);
        int[] right = getNextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int temp = (i - left[i]) * (right[i] - i) * num;
//            ans += temp;
            ans+=(long) (i - left[i]) * (right[i] - i) % MOD * arr[i] % MOD;
            ans%= MOD;

        }
        return ans ;
    }

    public int[] getNextSmaller(int[] nums) {
        int length = nums.length;
        int[] right = new int[length];
        Arrays.fill(right, length);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] > num) {
                right[stack.pollLast()] = i;
            }
            stack.offer(i);
        }
        return right;
    }

    public int[] getLastSmaller(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] >= num) {
                stack.pollLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.offer(i);
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr   = {71, 55, 82, 55};
//        int[] arr = {2, 1, 3, 1};
        int[] nextSmaller = solution.getNextSmaller(arr);
        int[] lastSmaller = solution.getLastSmaller(arr);

        System.out.println(Arrays.toString(lastSmaller));
        System.out.println(Arrays.toString(nextSmaller));
        System.out.println(solution.sumSubarrayMins(arr));
    }
}
