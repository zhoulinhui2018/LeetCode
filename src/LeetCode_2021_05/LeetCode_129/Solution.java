package LeetCode_2021_05.LeetCode_129;

import LeetCode_2021_05.TreeNode;

import java.util.Arrays;

public class Solution {
    private int ans=0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode root,int cur){
        if (root==null){
            return;
        }
        cur=cur*10+root.val;
        if (root.left==null&&root.right==null){
            ans+=cur;
            return;
        }
        dfs(root.left,cur);
        dfs(root.right,cur);
    }

    public int kthLargest(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        int right = countTreeNode(root.right);
        if (right==k-1){
            return root.val;
        }else if (right<k-1){
            return kthLargest(root.left,k-right-1);
        }else {
            return kthLargest(root.right,k);
        }
    }

    int countTreeNode(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+countTreeNode(root.left)+countTreeNode(root.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int mid=nums.length/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        node.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1, nums.length));
        return node;
    }
}
