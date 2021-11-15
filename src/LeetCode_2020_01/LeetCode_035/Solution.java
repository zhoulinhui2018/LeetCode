package LeetCode_2020_01.LeetCode_035;

import java.util.Arrays;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (i<0){
            i=-i-1;
        }
        return i;
    }
}
