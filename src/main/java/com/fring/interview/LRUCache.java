package com.fring.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }
    private DLinkedNode head, tail;

    int capacity, size;
    HashMap<Integer, DLinkedNode> map;
    public LRUCache(int capacity) {
        size=0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node==null){
            DLinkedNode tmp = new DLinkedNode(key, value);
            map.put(key, tmp);
            addToHead(tmp);
            size++;
            if(size>capacity){
                DLinkedNode rem_node = removeTail();
                map.remove(rem_node.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail(){
        DLinkedNode tmp = tail.prev;
        removeNode(tmp);
        return tmp;
    }

    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next = head.next;
        head.next.prev=node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
}
