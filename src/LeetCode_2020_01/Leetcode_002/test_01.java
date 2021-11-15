package LeetCode_2020_01.Leetcode_002;


public class test_01 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(9);
        listNode1.next.next=new ListNode(9);
        listNode1.next.next.next=new ListNode(9);
        listNode1.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next.next.next.next=new ListNode(9);
        listNode1.next.next.next.next.next.next.next.next.next=new ListNode(9);
        ListNode listNode2=new ListNode(9);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead=new ListNode(-1);
        ListNode p=l1,q=l2,curr=dummyHead;
        int carry=0;
        while (p!=null||q!=null){
            int l1Val=p!=null?p.val:0;
            int l2Val=q!=null?q.val:0;
            int sum=l1Val+l2Val+carry;
            curr.next=new ListNode(sum%10);
            carry=sum/10;
            if (p!=null){
                p=p.next;
            }
            if (q!=null){
                q=q.next;
            }
            curr=curr.next;
        }
        if (carry!=0){
            curr.next=new ListNode(carry);
        }
        return dummyHead.next;
    }
}

//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode root = new ListNode(0);
//        ListNode cursor = root;
//        int carry = 0;
//        while(l1 != null || l2 != null || carry != 0) {
//            int l1Val = l1 != null ? l1.val : 0;
//            int l2Val = l2 != null ? l2.val : 0;
//            int sumVal = l1Val + l2Val + carry;
//            carry = sumVal / 10;
//
//            ListNode sumNode = new ListNode(sumVal % 10);
//            cursor.next = sumNode;
//            cursor = sumNode;
//
//            if(l1 != null) {
//                l1 = l1.next;
//            }
//            if(l2 != null) {
//                l2 = l2.next;
//            }
//        }
//
//        return root.next;
//    }
//}