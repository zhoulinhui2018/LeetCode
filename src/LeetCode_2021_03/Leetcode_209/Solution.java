package LeetCode_2021_03.Leetcode_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int left=0,right=0;
        int sum=0;
        while (right<nums.length){
            int num1 = nums[right];
            right++;
            sum+=num1;
            while (sum>=target){
                ans=Math.min(ans,right-left);
                int num2 = nums[left];
                left++;
                sum-=num2;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
