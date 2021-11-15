package LeetCode_2021_04.LeetCode_213;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        return Math.max(robHelper(Arrays.copyOfRange(nums,0,nums.length-1)),robHelper(Arrays.copyOfRange(nums,1,nums.length)));
    }

    int robHelper(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
