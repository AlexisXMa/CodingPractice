package design;

/*
146. LRU Cache
 */

import java.util.*;

public class LRUCache {
    // Method: Hashmap + DoubleLinkedList
    // Time = O(1) both for put and get
    // Space = O(capacity) for a hashmap and double linked list
    static class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }

    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        head = new Node(0, 0);     // pseudo head
        tail = new Node(0, 0);     // pseudo tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        } else {
            node.value = value;
            update(node);
        }

        if (count > capacity) {
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
    }

    private void update(Node node){
        remove(node);
        add(node);
    }

    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
        this.count++;
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
        this.count--;
    }
}
