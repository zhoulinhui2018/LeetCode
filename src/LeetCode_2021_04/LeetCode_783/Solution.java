package LeetCode_2021_04.LeetCode_783;

import LeetCode_2021_04.TreeNode;

public class Solution {

    private int ans= Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        int left = maxValueOfTree(root.left);
        int right = minValueOfTree(root.right);
        if (left!=-1){
            ans=Math.min(Math.abs(root.val-left),ans);
        }
        if (right!=-1){
            ans=Math.min(Math.abs(root.val-right),ans);
        }

        dfs(root.left);
        dfs(root.right);
    }

    int minValueOfTree(TreeNode root){
        if (root==null){
            return -1;
        }
        TreeNode treeNode=root;
        while (treeNode.left!=null){
            treeNode=treeNode.left;
        }
        return treeNode.val;
    }

    int maxValueOfTree(TreeNode root){
        if (root==null){
            return -1;
        }
        TreeNode treeNode=root;
        while (treeNode.right!=null){
            treeNode=treeNode.right;
        }
        return treeNode.val;
    }
}
