package LeetCode_2021_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans;
    private List<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        path=new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,nums.length,nums);
        return ans;
    }

    void dfs(int index,int n,int[] nums){
        ans.add(new ArrayList<>(path));
        if (index>=n){
            return;
        }
        for (int i=index;i<n;i++){
            if (i>index&&nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(index+1,n,nums);
            path.remove(path.size()-1);
        }
    }
}
