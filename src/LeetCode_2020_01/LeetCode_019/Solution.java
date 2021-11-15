package LeetCode_2020_01.LeetCode_019;

import LeetCode_2020_01.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i=head,j=head;
        while (n-->0){
            j=j.next;
        }
        if (j==null){
            return i.next;
        }
        while (j.next!=null){
            i=i.next;
            j=j.next;
        }
        i.next=i.next.next;
        return head;
    }
}
