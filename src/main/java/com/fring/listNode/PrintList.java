package com.fring.listNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintList {
    public ListNode printListFromTailToHead(ListNode head){
        ListNode new_head = new ListNode(-1);
        while(head!=null){
            ListNode tmp = head.next;
            head.next = new_head.next;
            new_head.next = head;
            head=tmp;
        }

        /**
         * 这才是最关键的一步
         * */
        return new_head.next;
    }

    public void printListFromTailToHeadByStack(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.value);
            head=head.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 因为递归具有栈的性质，考虑用递归去输出
     * */
    public void printListFromTailToHeadByIteration(ListNode head){
        if(head!=null){
            printListFromTailToHeadByIteration(head.next);
            System.out.println(head.value);
        }
    }

    public void printList(ListNode head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
    //存在一个问题，初始化头节点的时候会有一个-1的节点
    /**
     * 返回头节点的next
     * */
    public static void main(String[] args) {
        PrintList obj = new PrintList();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        obj.printList(head);
        System.out.println("---------");
        obj.printListFromTailToHeadByStack(head);
        System.out.println("---------");
        obj.printListFromTailToHeadByIteration(head);
        System.out.println("---------");
        head = obj.printListFromTailToHead(head);
        obj.printList(head);

    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value){ this.value=value; }
}