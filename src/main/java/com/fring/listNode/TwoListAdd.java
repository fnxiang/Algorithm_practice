package com.fring.listNode;
/** qy 字节一面算法题 */
public class TwoListAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode yummy = new ListNode(-1);
        ListNode n_l1 = l1;
        ListNode n_l2 = l2;
        int mod = 0;
        yummy.next = n_l1;
        ListNode pre = yummy;

        /** 要时刻记得把mod换成0 */
        while(n_l1!=null&&n_l2!=null){
            n_l1.value = n_l1.value+n_l2.value+mod;
            if(n_l1.value>=10){
                /** 先取模再重新赋值 */
                mod = n_l1.value/10;
                n_l1.value = n_l1.value%10;
            }else{
                mod = 0;
            }
            n_l1=n_l1.next;
            n_l2=n_l2.next;
            pre = pre.next;
        }
        /** 这个情况没有考虑到 */
        if(n_l1==null&&n_l2==null&&mod!=0) {
            pre.next=new ListNode(mod);
            return yummy.next;
        }

        if(n_l1==null) {
            pre.next = n_l2;
        }
        pre=pre.next;
        while(mod!=0&&pre.next!=null){
            pre.value = pre.value+mod;
            mod = 0;
            if(pre.value>=10){
                mod = pre.value/10;
                pre.value = pre.value%10;
            }
            pre=pre.next;
        }

        if(mod!=0){
            pre.value = pre.value+mod;
            if(pre.value>=10){
                pre.next = new ListNode(pre.value/10);
                pre.value = pre.value%10;
            }
        }

        return yummy.next;
    }

    public ListNode reverseList(ListNode head){
        ListNode n_head = new ListNode(-1);
        while(head!=null){
            ListNode tmp = head.next;
            head.next = n_head.next;
            n_head.next = head;
            head = tmp;
        }
        return n_head.next;
    }

    public static void main(String[] args){

    }
}
