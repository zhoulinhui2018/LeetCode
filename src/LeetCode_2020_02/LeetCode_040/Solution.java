package LeetCode_2020_02.LeetCode_040;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = calcEachNumOfNums(candidates);
        if (candidates.length==0||candidates==null){
            return null;
        }
        List<List<Integer>> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        backtrack(list,stack,map,target);
        return list;
    }

    public void backtrack(List<List<Integer>> res,
                          Stack<Integer> stack,
                          Map<Integer, Integer> map,
                          int target) {
        if (target==0){
            res.add(new ArrayList<Integer>(stack));
        }else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (target>=entry.getKey()&&entry.getValue()>0&&(!stack.isEmpty()&&entry.getKey()>=stack.peek()||stack.isEmpty())){
                    map.put(entry.getKey(),entry.getValue()-1);
                    stack.push(entry.getKey());
                    backtrack(res,stack,map,target-entry.getKey());
                    stack.pop();
                    map.put(entry.getKey(),entry.getValue()+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Solution().combinationSum2(nums,8));
    }

    public Map<Integer, Integer> calcEachNumOfNums(int[] nums) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }
        return treeMap;
    }
}
