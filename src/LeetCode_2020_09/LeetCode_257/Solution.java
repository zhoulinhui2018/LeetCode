package LeetCode_2020_09.LeetCode_257;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution {
    private List<String> ans;
    Solution(){
        ans=new ArrayList<>();
    }
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return ans;
    }

    void dfs(TreeNode root, String temp){
        if (root==null){
            return;
        }
        temp+=String.valueOf(root.val);
        if (root.left==null&&root.right==null){
            ans.add(temp);
            return;
        }

        dfs(root.left,temp);
        dfs(root.right,temp);
    }
}
