package LeetCode_2021_05.LeetCode_199;

import LeetCode_2021_05.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.pollFirst();
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
                temp.add(first.val);
            }
            levelList.add(temp);
        }



        for (ArrayList<Integer> list : levelList) {
            ans.add(list.get(list.size() - 1));
        }
        return ans;
    }
}
