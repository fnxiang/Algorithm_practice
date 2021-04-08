package com.fring.listNode;

public class DeleteKNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode n_head = head;
        int count = 0;
        while (head!=null){
            count++;
            head=head.next;
        }
        count-=k-1;
        while (n_head!=null&&count!=0){
            count--;
            n_head=n_head.next;
        }
        return n_head;
    }
}
