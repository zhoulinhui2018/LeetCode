package LeetCode_2021_04.LeetCode_92;

import LeetCode_2021_04.ListNode;


public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==1){
            return reverseN(head,n);
        }
        ListNode last = reverseBetween(head.next, m - 1, n - 1);
        head.next=last;
        return head;
    }

    private ListNode successor=null;

    public ListNode reverseN(ListNode head,int n){
        if (n==1){
            successor=head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next=head;
        head.next=successor;
        return last;
    }
}
