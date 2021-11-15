package LeetCode_2021_04.LeetCode_138;

import LeetCode_2021_04.Node;

public class Solution {
    public Node copyRandomList(Node head) {
        Node l=head;
        while (l!=null){
            Node node = new Node(l.val);
            node.next=l.next;
            l.next=node;
            l=node.next;
        }
        l=head;
        while (l!=null){
            if (l.random!=null){
                l.next.random=l.random.next;
            }
            l=l.next.next;
        }
        l=head;
        Node ans=l.next;
        Node l2=l.next;

        while (l2.next!=null){
            l.next=l2.next;
            l=l.next;
            l2.next=l.next;
            l2=l2.next;
        }
        l.next=null;


        return ans;
    }
}
