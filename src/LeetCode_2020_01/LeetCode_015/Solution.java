package LeetCode_2020_01.LeetCode_015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret=new ArrayList<>();
        int L=0,R=nums.length-1;
        int sum=0;
        for (int i = 0; i < nums.length&&nums[i]<=0; i++) {
            int num = nums[i];
            if (i!=0&&num==nums[i-1]){
                continue;
            }
            L=i+1;
            R=nums.length-1;
            while (L < R){
                sum=num+nums[L]+nums[R];
                if (sum==0){
                    if (nums[L]==nums[L-1]&&R!=nums.length-1&& nums[R]==nums[R+1]){
                        L++;
                        R--;
                        continue;
                    }
                    ret.add(new ArrayList<>(Arrays.asList(num,nums[L],nums[R])));
                    L++;
                    R--;
                }else if (sum<0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return ret;
    }


        public static List<List<Integer>> threeSum2(int[] nums) {
            List<List<Integer>> ans = new ArrayList();
            int len = nums.length;
            if(nums == null || len < 3) {return ans;}
            Arrays.sort(nums); // 排序
            for (int i = 0; i < len ; i++) {
                if(nums[i] > 0) {break;} // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if(i > 0 && nums[i] == nums[i-1]) {continue;} // 去重
                int L = i+1;
                int R = len-1;
                while(L < R){
                    int sum = nums[i] + nums[L] + nums[R];
                    if(sum == 0){
                        ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) {L++;} // 去重
                        while (L<R && nums[R] == nums[R-1]) {R--;} // 去重
                        L++;
                        R--;
                    }
                    else if (sum < 0){ L++;}
                    else if (sum > 0) {R--;}
                }
            }
            return ans;
        }



    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
}
