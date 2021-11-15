package LeetCode_2021_03.Leetcode_560;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int left=0,right=0;
        int ans=0;
        int curSum=0;
        for (int i=0;i<nums.length;i++){
            curSum=0;
            for (int j=i;j<nums.length;j++){
                curSum+=nums[j];
                if (curSum==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
