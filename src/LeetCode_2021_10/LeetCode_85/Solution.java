package LeetCode_2021_10.LeetCode_85;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author zhoul
 * @Description: TODO
 * @date 2021/12/2
 */
public class Solution {
    int ans = 0;

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] left1cnt = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = matrix[i][j];
                if (j == 0) {
                    left1cnt[i][j] = c == '1' ? 1 : 0;
                } else {
                    left1cnt[i][j] = c == '1' ? left1cnt[i][j - 1] + 1 : 0;
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            int[] left = new int[rows];
            int[] right = new int[rows];
            Arrays.fill(right, rows);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left1cnt[stack.peekLast()][col] > left1cnt[i][col]) {
                    right[stack.pollLast()] = i;
                }
                left[i] = stack.isEmpty() ? -1 : stack.peekLast();
                stack.offer(i);
            }
            for (int i = 0; i < rows; i++) {
                ans = Math.max(ans, left1cnt[i][col] * (right[i] - left[i] - 1));
            }
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            pre += num % 2 == 0 ? 0 : 1;
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
