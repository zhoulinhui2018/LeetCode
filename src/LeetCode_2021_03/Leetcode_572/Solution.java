package LeetCode_2021_03.Leetcode_572;

import LeetCode_2021_03.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null){
            return false;
        }
        return isSameTree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    boolean isSameTree(TreeNode s,TreeNode t){
        if (s==null&&t==null){
            return true;
        }
        if (s==null||t==null){
            return false;
        }
        return s.val==t.val&&isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null){
            return false;
        }
        return subStructure(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    boolean subStructure(TreeNode A,TreeNode B){
        if (B==null){
            return true;
        }
        if (A==null){
            return false;
        }

        return A.val==B.val&&subStructure(A.left,B.left)&&subStructure(A.right,B.right);
    }
}
