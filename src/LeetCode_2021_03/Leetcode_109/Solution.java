package LeetCode_2021_03.Leetcode_109;

import LeetCode_2020_01.ListNode;
import LeetCode_2021_03.TreeNode;


public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }else if (head.next==null){
            return new TreeNode(head.val);
        }
        ListNode middle = middle(head);
        ListNode temp=middle.next;
        middle.next=null;
        TreeNode node = new TreeNode(middle.val);
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(temp);
        return node;
    }

    ListNode middle(ListNode head){
        ListNode slow=head,fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
