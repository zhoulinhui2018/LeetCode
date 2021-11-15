package LeetCode_2021_03.Leetcode_91;

import java.util.Arrays;

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            dp[i] = 0;
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            String substring = s.substring(i - 2, i);
            int temp = Integer.parseInt(substring);
            if (temp >= 1 && temp <= 26 && substring.charAt(0) != '0') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }


    private int ans2 = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return ans2;
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left, right;
        left = Arrays.copyOfRange(arr, 0, mid);
        right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        if (left.length == 0) {
            return right;
        }
        if (right.length == 0) {
            return left;
        }
        int[] ans = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                ans[k++] = left[i++];
            } else {
                ans[k++] = right[j++];
                ans2 += left.length - i;
            }
        }
        while (i < left.length) {
            ans[k++] = left[i++];
        }
        while (j < right.length) {
            ans[k++] = right[j++];
        }
        return ans;
    }
}
