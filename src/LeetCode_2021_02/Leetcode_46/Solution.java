package LeetCode_2021_02.Leetcode_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        int len = nums.length;
        if (len == 0) {
            return ans;
        }
        dfs(0, len, path, used, nums);
        return ans;
    }

    private void dfs(int index, int len, List<Integer> path, boolean[] used, int[] nums) {
        if (index == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(index + 1, len, path, used, nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


}
