package LeetCode_2021_03.Leetcode_907;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    private static final int MOD = 1000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int ans=0;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            while (!stack.isEmpty()&&arr[stack.peekLast()]>=cur){
                right[stack.peekLast()]=i;
                stack.pollLast();
            }
            left[i]=stack.isEmpty()?-1:stack.peekLast();
            stack.offer(i);
        }
        for (int i=0;i<n;i++){
            int mm=i-left[i]-1;
            int nn=right[i]-i-1;
            ans+=(long) (i - left[i]) * (right[i] - i) % MOD * arr[i] % MOD;
            ans%= MOD;
        }
        return ans;
    }
}
