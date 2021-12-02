package LeetCode_2021_10.LeetCode_496;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/11/20
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] nextGreater = getNextGreaterIndex(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int index = getIndex(num, nums2);
            ans[i] = nextGreater[index] == -1 ? -1 : nums2[nextGreater[index]];
        }
        return ans;
    }

    public int[] getNextGreaterIndex(int[] nums) {
        int length = nums.length;
        int[] right = new int[length];
        Arrays.fill(right, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < right.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] < num) {
                right[stack.pollLast()] = i;
            }
            stack.offer(i);
        }
        return right;
    }

    public int getIndex(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 == num) {
                return i;
            }
        }
        return -1;
    }

    public int[] getNextGreater(int[] nums) {
        int length = nums.length;
        int[] right = new int[length];
        Arrays.fill(right, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < right.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peekLast()] < num) {
                right[stack.pollLast()] = num;
            }
            stack.offer(i);
        }
        return right;
    }


    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] nums2 = new int[2 * length];
        System.arraycopy(nums, 0, nums2, 0, length);
        System.arraycopy(nums, 0, nums2, length, length);
        int[] nextGreater = getNextGreater(nums2);
        int[] ans = Arrays.copyOf(nextGreater, length);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        Solution solution = new Solution();
        int[] nextGreater = solution.getNextGreater(arr);
        int[] nextGreaterIndex = solution.getNextGreaterIndex(arr);
        System.out.println(Arrays.toString(nextGreater));
        System.out.println(Arrays.toString(nextGreaterIndex));
    }


}
