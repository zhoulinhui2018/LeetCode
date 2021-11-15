package LeetCode_2020_09.LeetCode_16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=1000000;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int firstNum = nums[i];
            int j=i+1,k=n-1;
            while (j<k){
                int sum=firstNum+nums[j]+nums[k];
                if (sum==target) {
                    return target;
                }else if (Math.abs(sum-target)<Math.abs(ans-target)){
                    ans=sum;
                }
                if (sum<target){
                    j++;
                    while (j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }else{
                    k--;
                    while (j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}