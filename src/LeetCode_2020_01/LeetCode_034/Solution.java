package LeetCode_2020_01.LeetCode_034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int left=0,right=nums.length;
        int[] result=new int[]{-1,-1};
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                right=mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        if (left<=nums.length&&nums[left]==target){
            result[0]=left-1;
        }
        left=0;
        right=nums.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        if (right>0&&nums[right-1]==target){
            result[1]=right-1;
        }
        return result;
    }
}
