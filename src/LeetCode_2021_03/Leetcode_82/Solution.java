package LeetCode_2021_03.Leetcode_82;

import LeetCode_2020_01.ListNode;

import java.util.List;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        ListNode l1=dummyHead,l2=head;
        while (l2!=null&&l2.next!=null){
            if (l1.next.val==l2.next.val){
                while (l2.next!=null&&l1.next.val==l2.next.val){
                    l2=l2.next;
                }
                l1.next=l2.next;
                l2=l2.next;
            }else {
                l1=l1.next;
                l2=l2.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            if (slow.val!=fast.val){
                slow.next=fast;
                slow=fast;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }
}
