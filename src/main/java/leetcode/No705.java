package leetcode;

import java.util.ArrayList;
import java.util.List;

public class No705 {
    /** Initialize your data structure here. */
    ListNode[] list = new ListNode[10009];

    public void add(int key) {
        int index = getIndex(key);
        ListNode node = list[index];
        ListNode prev = null;
        while(node!=null){
            if(node.data==key){
                return;
            }
            prev = node;
            node = node.next;
        }
        if(prev!=null){
            prev.next = new ListNode(key);
        }else{
            list[index].data = key;
        }

    }

    public void remove(int key) {
        int index = getIndex(key);
        ListNode node = list[index];
        ListNode prev = null;
        while(node!=null){
            if(node.data==key){
                if(prev!=null){
                    prev.next = node.next;
                    break;
                }else{
                    list[index] = node.next;
                }
            }
            prev = node;
            node = node.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        ListNode node = list[index];

        while(node!=null){
            if(node.data==key){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % list.length;
    }

    class ListNode{
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data = data;
        }
    }
}

class MyHashSet {
    // 由于使用的是「链表」，这个值可以取得很小
    Node[] nodes = new Node[10009];

    public void add(int key) {
        // 根据 key 获取哈希桶的位置
        int idx = getIndex(key);
        // 判断链表中是否已经存在
        Node loc = nodes[idx], tmp = loc;
        if (loc != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }
        Node node = new Node(key);

        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        // 尾插法
        if (tmp != null) {
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            Node prev = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (prev != null) {
                        prev.next = loc.next;
                    } else {
                        nodes[idx] = loc.next;
                    }
                    return;
                }
                prev = loc;
                loc = loc.next;
            }
        }
    }

    public boolean contains(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if (loc != null) {
            while (loc != null) {
                if (loc.key == key) {
                    return true;
                }
                loc = loc.next;
            }
        }
        return false;
    }

    static class Node {
        private int key;
        private Node next;
        private Node(int key) {
            this.key = key;
        }
    }

    int getIndex(int key) {
        // 因为 nodes 的长度只有 10009，对应的十进制的 10011100011001（总长度为 32 位，其余高位都是 0）
        // 为了让 key 对应的 hash 高位也参与运算，这里对 hashCode 进行右移异或
        // 使得 hashCode 的高位随机性和低位随机性都能体现在低 16 位中
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}