package LeetCode_2021_03.Leetcode_143;

import LeetCode_2020_01.ListNode;

import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        ListNode pre=null,tail=null;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast!=null){
            tail=slow.next;
            slow.next=null;
        }else {
            tail=slow;
            pre.next=null;
        }
        ListNode tail2 = reverseList(tail);
        ListNode newHead = new ListNode(0);
        ListNode temp=newHead;
        while (tail2!=null){
            temp.next=head;
            head=head.next;
            temp.next.next=tail2;
            tail2=tail2.next;
            temp=temp.next.next;
        }
        if (head!=null){
            temp.next=head;
        }
        head=newHead.next;
    }

    ListNode reverseList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
