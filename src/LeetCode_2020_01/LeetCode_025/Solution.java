package LeetCode_2020_01.LeetCode_025;

import LeetCode_2020_01.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        listNode1.next.next.next.next=new ListNode(5);
        ListNode listNode = solution.reverseKGroup(listNode1, 2);


        solution.printList(listNode);
        System.out.println();
//        ListNode listNode2 = solution.reverseKList(listNode1, 2);
//        solution.printList(listNode2);
//        System.out.println();
//        solution.printList(listNode1);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode preHead=dummyHead;
        ListNode start=head;
        ListNode preStart=dummyHead;

        int i=k;
        while (head!=null){
            i=k;
            while (i--!=0){

                preHead=preHead.next;
                head=head.next;
                if (head==null){
                    break;
                }
            }
            if (head!=null||i==0&&head==null){
                ListNode tempNode=preHead;
                ListNode listNode = reverseKList(start, k);
                preHead=start;
                preStart.next=listNode;
                preStart=start;
                start=head;
            }
        }
        return dummyHead.next;
    }

    public ListNode reverseKList(ListNode head,int k){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode preHead=dummyHead,head2=head;
        int i=k;
        if (head2==null||k==1){
            return head2;
        }
        while (--i!=0){
            preHead=preHead.next;
            head2=head2.next;
        }
        preHead.next=head2.next;
        head2.next=dummyHead.next;

        ListNode listNode = reverseKList(head2.next, k - 1);
        head2.next=listNode;
        head=head2;
        return head2;
    }

    public void printList(ListNode head){
        int flag=1;
        while (head!=null){
            if (flag==1){
                flag=0;
                System.out.print(head.val);
                head=head.next;
            }else {
                System.out.print("-->"+head.val);
                head=head.next;
            }
        }
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
