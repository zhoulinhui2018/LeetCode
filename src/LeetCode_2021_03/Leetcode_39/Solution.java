package LeetCode_2021_03.Leetcode_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,candidates,0,target);
        return ans;
    }

    void dfs(int index,int[] candidates,int curSum,int target){
        if (curSum==target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (curSum>target){
            return;
        }
        for (int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(index,candidates,curSum+candidates[i],target);
            path.remove(path.size()-1);
        }
    }



}
