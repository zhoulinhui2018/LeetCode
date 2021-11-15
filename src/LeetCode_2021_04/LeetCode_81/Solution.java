package LeetCode_2021_04.LeetCode_81;

public class Solution {
    public boolean search(int[] nums, int target) {
        int index = twoSearch(nums, target);
        if (index==-1){
            return false;
        }else {
            return true;
        }
    }

    int twoSearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid]==target){
                return mid;
            }

            if (nums[low]==nums[high]){
                low++;
                continue;
            }

            if (nums[low]<nums[mid]){
                if (target>=nums[low]&&target<nums[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else{
                if (target>nums[mid]&&target<=nums[high]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
