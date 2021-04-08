package com.fring.listNode;

public class FindNode {
    /** 该题可以用双指针求解 */
    public int kthToLast(ListNode head, int k) {
        ListNode yummy = head;
        int length = 0;
        while (yummy!=null){
            length++;
            yummy=yummy.next;
        }
        k=length-k;
        while (k-->0){
            head=head.next;
        }
        return head.next.value;
    }

    public int kthToLastBest(ListNode head, int k){
        ListNode yummy = head;
        while (k-->0){
            yummy=yummy.next;
        }
        while(yummy!=null){
            head=head.next;
            yummy=yummy.next;
        }
        return head.value;
    }
}
