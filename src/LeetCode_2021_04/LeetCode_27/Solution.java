package LeetCode_2021_04.LeetCode_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0,j=0;
        while (j<nums.length){
            if (nums[j]==val){
                j++;
            }else {
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while (j<nums.length){
            if (nums[i]==nums[j]) {
                j++;
            }else {
                i++;
                nums[i]=nums[j++];
            }
        }
        return i+1;
    }
}
