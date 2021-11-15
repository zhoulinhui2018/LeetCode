package LeetCode_2021_04.LeetCode_220;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int left=0,right=1;
        while (right<nums.length){
            int cur=nums[right];
            right++;
            if (Math.abs(nums[left]-cur)<=t){
                return true;
            }
            while (right-left>k){
                left++;
            }
        }
        return false;
    }
}
