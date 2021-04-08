package com.fring.listNode;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA =0, countB=0;
        ListNode head1=headA;
        ListNode head2=headB;
        while (headA!=null){
            countA++;
            headA=headA.next;
        }
        while (headB!=null){
            countB++;
            headB=headB.next;
        }
        int k = Math.abs(countA-countB);
        if(countA>countB){
            while (k-->0){
                head1=head1.next;
            }
        }else {
            while (k-->0){
                head2=head2.next;
            }
        }
        while (head1!=null&&head2!=null){
            if(head1==head2)return head1;
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(6);
        n2.next = n1.next.next;
        IntersectionNode obj = new IntersectionNode();
        System.out.println(obj.getIntersectionNode(n1, n2).value);
    }
}
