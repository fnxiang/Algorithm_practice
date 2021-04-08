package com.fring.listNode;

public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1!=null&&l2!=null){

            if (l1.value>l2.value){
                tmp.next = l2;
                l2 = l2.next;
            }else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp=tmp.next;
        }
        if(l1==null) tmp.next = l2;
        else tmp.next = l1;
        return head.next;
    }
}
