package com.fring.listNode;

public class DuplicationNodeDelete {

    /**
     * 初始思路是利用Set的数据唯一性判断，可以用递归和双指针解决
     * */
    public ListNode deleteDuplicationNode(ListNode head){
        if(head == null || head.next==null)
            return head;

        ListNode next = head.next;

        if(head.value==next.value){
            while (next!=null&&head.value==next.value)
                next=next.next;
            return deleteDuplicationNode(next);
        }else{
            head.next = deleteDuplicationNode(head.next);
            return head;
        }
    }



    public ListNode deleteNode(ListNode head, int val) {
        /** 利用next判断，先申请一个新的节点加在头节点*/
        ListNode n_head = new ListNode(0);
        n_head.next = head;
        ListNode node = n_head;
        while (n_head.next!=null){
            if(n_head.next.value==val) n_head.next = n_head.next.next;
            else n_head=n_head.next;
        }
        head = node.next;
        printList(head);
        return head;
    }

    public ListNode deleteDuplicationNodeByPointer(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        /** 设置哑节点 */
        ListNode n_head = new ListNode(-1);

        n_head.next = head;
        ListNode pre = n_head;
        while(head!=null&&head.next!=null){
            /** 有相等元素出现*/
            if(head.value == head.next.value){
                while(head.next!=null&&head.value == head.next.value){
                    head=head.next;
                }
                /** 删除相等元素剩余的左后一个元素*/
                pre.next = head.next;
            }else{
                pre = head;
            }
            head=head.next;
        }
        printList(n_head.next);
        return n_head.next;
    }


    public void printList(ListNode head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }

    public static void main(String[] args) {
        DuplicationNodeDelete obj = new DuplicationNodeDelete();
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        obj.deleteDuplicationNodeByPointer(head);
//        ListNode n_head = obj.deleteDuplicationNode(head);
//        obj.printList(n_head);

    }

}
