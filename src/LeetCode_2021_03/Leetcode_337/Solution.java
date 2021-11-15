package LeetCode_2021_03.Leetcode_337;

import LeetCode_2021_03.TreeNode;

public class Solution {
    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0],dfs[1]);
    }

    public int[] dfs(TreeNode root){
        if (root==null){
            return new int[]{0,0};
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int do_it=root.val+left[1]+right[1];
        int not_do=Math.max(left[1],left[0])+Math.max(right[0],right[1]);

        return new int[]{do_it,left[0]+not_do};
    }
}
