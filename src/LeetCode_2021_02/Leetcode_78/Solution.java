package LeetCode_2021_02.Leetcode_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(path,0,nums);
        return ans;
    }

    void dfs(List<Integer> path,int index,int[] nums){
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            dfs(path,i+1, nums);
            path.remove(path.size()-1);
        }
    }
}
