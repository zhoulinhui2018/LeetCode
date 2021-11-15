package LeetCode_2020_02.LeetCode_039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();

    public static void main(String[] args) {
        int[] nums=new int[]{2,3,6,7};
        int target=7;
        System.out.println(new Solution().combinationSum(nums,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> integerList=new ArrayList<>();
        return backtrack(res,integerList,candidates,target);
    }

    public List<List<Integer>> backtrack(List<List<Integer>> result,List<Integer> integerList,int[] nums,int target){
        List<List<Integer>> res=result;
        List<Integer> list=new ArrayList<>(integerList);
        if (target==0){
            res.add(list);
            return res;
        }else {
            Integer maxNum = integerList.size()>0?integerList.get(integerList.size() - 1):nums[0];
            int i = Arrays.binarySearch(nums, maxNum);
            while (i<=nums.length-1){
                if (target>=nums[i]){
                    integerList.add(nums[i]);
                    res = backtrack(result, integerList, nums, target - nums[i]);
                    integerList.remove(integerList.size()-1);
                }
                i++;
            }
            return res;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null)return res;
        dfs(target,0,new Stack<Integer>(),candidates);
        return res;
    }
    //深度遍历
    private void dfs(int target, int index, Stack<Integer> pre, int[] candidates) {
        //等于零说明结果符合要求
        if (target==0){
            res.add(new ArrayList<>(pre));
            return;
        }
        //遍历，index为本分支上一节点的减数的下标
        for (int i=index;i<candidates.length;i++){
            //如果减数大于目标值，则差为负数，不符合结果
            if (candidates[i]<=target){
                pre.push(candidates[i]);
                //目标值减去元素值
                dfs(target-candidates[i],i,pre, candidates);
                //每次回溯将最后一次加入的元素删除
                pre.pop();
            }
        }
    }
}
