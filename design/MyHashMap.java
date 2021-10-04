package design;

/*
706. Design HashMap
 */

import java.util.*;

public class MyHashMap {
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Bucket {
        private List<Node<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new ArrayList<Node<Integer, Integer>>();
        }

        public Integer get(Integer key) {
            for (Node<Integer, Integer> node : this.bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
            return -1;
        }

        public void put(Integer key, Integer value) {
            boolean found = false;
            for (Node<Integer, Integer> node: this.bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    found = true;
                }
            }
            if (!found) {
                this.bucket.add(new Node<Integer, Integer>(key, value));
            }
        }

        public void remove(Integer key) {
            for (Node<Integer, Integer> node: this.bucket) {
                if (node.key.equals(key)) {
                    this.bucket.remove(node);
                    break;
                }
            }
        }
    }


    private int keySpace;
    private List<Bucket> hashTable;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < this.keySpace; i++) {
            this.hashTable.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashTable.get(hashKey).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).remove(key);
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}
