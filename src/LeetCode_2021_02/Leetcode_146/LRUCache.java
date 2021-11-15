package LeetCode_2021_02.Leetcode_146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode{
        private int key;
        private int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){
            this.key=0;
            this.value=0;
            pre=null;
            next=null;
        }
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
            pre=null;
            next=null;
        }
    }
    private Map<Integer,DLinkedNode> map=new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            map.get(key).value=value;
            moveToHead(node);
        }else {
            ++size;
            if (size>capacity){
                size--;
                DLinkedNode node = new DLinkedNode(key, value);
                map.put(key,node);
                addToHead(node);
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
            }else {
                DLinkedNode node = new DLinkedNode(key, value);
                addToHead(node);
                map.put(key,node);
            }
        }
    }

    private void addToHead(DLinkedNode node){
        head.next.pre=node;
        node.next=head.next;
        head.next=node;
        node.pre=head;
    }

    private void removeNode(DLinkedNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}