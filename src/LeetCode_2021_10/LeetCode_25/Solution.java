package LeetCode_2021_10.LeetCode_25;

import LeetCode_2021_05.TreeNode;
import LeetCode_2021_10.ListNode;

public class Solution {
    public ListNode reverse(ListNode a,ListNode b) {
        if (a==b||a.next==b){
            return a;
        }
        ListNode last = reverse(a.next, b);
        ListNode temp = a.next.next;
        a.next.next=a;
        a.next=temp;
        return last;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null){
            return null;
        }
        ListNode a = head,b=head;
        for (int i = 0; i < k; i++) {
            if (b==null){
                return head;
            }
            b=b.next;
        }
        ListNode c = reverse(a, b);
        head.next=reverseKGroup(b,k);
        return c;
    }

    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}


