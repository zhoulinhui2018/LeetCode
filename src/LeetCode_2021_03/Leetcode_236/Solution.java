package LeetCode_2021_03.Leetcode_236;

import LeetCode_2021_03.TreeNode;
import jdk.jfr.consumer.RecordedThread;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null&&right!=null){
            return root;
        }else if (left==null&&right!=null){
            return right;
        }else if (left != null){
            return left;
        }else {
            return null;
        }
    }
}
