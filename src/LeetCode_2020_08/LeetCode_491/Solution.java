package LeetCode_2020_08.LeetCode_491;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(nums,0,path ,ans);
        return ans;
    }

    void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> ans){
        if (path.size()>=2){
            ans.add(new ArrayList<Integer>(path));
        }
        for (int i=index;i<nums.length;i++){
            if (path.size()==0||nums[i]>path.get(path.size()-1)){
                path.add(nums[i]);
                dfs(nums,i+1,path, ans);
                path.remove(path.size()-1);
            }
        }
    }
}