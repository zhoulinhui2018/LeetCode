package LeetCode_2021_03.Leetcode_543;

import LeetCode_2021_03.TreeNode;

import java.util.*;

public class Solution {
    private int ans=Integer.MIN_VALUE;
    private int ans2=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=depthOfBinaryTree(root.left);
        int right=depthOfBinaryTree(root.right);
        ans=Math.max(ans,left+right);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return ans;
    }

    int depthOfBinaryTree(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(depthOfBinaryTree(root.left),depthOfBinaryTree(root.right));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root==null){
            return 0;
        }
        ans2=1;
        longest(root,root.val);
        return ans2;
    }

    int longest(TreeNode root,int value){
        if (root==null){
            return 0;
        }
        int left = longest(root.left, value);
        int right= longest(root.right,value);
        ans2=Math.max(ans2, left+right);
        if (root.val!=value){
            return 0;
        }
        return 1+Math.max(left,right);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(temp);
        }
        int size = ans.size();
        for (int i=1;i<size;i+=2){
            List<Integer> temp = ans.get(i);
            Collections.reverse(temp);
        }
        return ans;
    }


}
