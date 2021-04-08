package com.fring.listNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RotateRightList {

    /** 超出时间限制 */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode yummy = new ListNode(-1);
        Deque<ListNode> queue = new LinkedList<>();
        int length = 0;
        while(head!=null){
            length++;
            queue.push(head);
            head = head.next;
            queue.peek().next=null;
        }
        k=k%length;
        while (k-->0){
            queue.addLast(queue.pop());
        }

        while (!queue.isEmpty()){
            queue.peek().next = yummy.next;
            yummy.next = queue.pop();
        }
        printList(yummy.next);
        return yummy.next;
    }

    public ListNode recurList(ListNode head, int k){
        if(head==null||head.next==null) return head;
        ListNode yummy = head;
        int length = 1;
        while (head.next!=null){
            length++;
            head = head.next;
        }
        if (k==0) return yummy;
        /** K应该为对length取模后走length -k-1步，因为是从尾部开始计数的*/
        k=length-k%length-1;
        head.next = yummy;
        while (k-->0){
            yummy=yummy.next;
        }
        head = yummy.next;
        yummy.next = null;
        printList(head);
        return head;
    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }

    public static void main(String[] args) {
        RotateRightList obj = new RotateRightList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.recurList(head, 2);
    }
}

