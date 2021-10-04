package design;

/*
706. Design HashMap
 */

import java.util.Arrays;

public class HashMapII<K, V> {
    // Node is a static class of MyHashMap, since it is:
    // very closely bonded to MyHashMap class.
    // We probably need to access this class outside of the MyHashMap class.
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // static final variable are global constants
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int SCALE_FACTOR = 2;

    private Node<K, V>[] array;
    private int size;   // how many key-value pairs are actually stored in the HashMap.
    private float loadFactor;   // determine when to rehash.

    public HashMapII() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMapII(int capacity, float loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be <= 0");
        }
        this.array = (Node<K, V>[]) (new Node[capacity]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    private int hash(K key) {
        // null key
        if (key == null) {
            return 0;
        }
        int hashNumber = key.hashCode();
        return Math.abs(hashNumber);
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        // v1, v2 both possibly to be null.
        if (v1 == null && v2 == null) {
            return true;
        } else if (v1 == null || v2 == null) {
            return false;
        }
        return v1.equals(v2);
    }

    // O(n), traverse the whole array, and traverse each of the linked list in the array.
    public boolean containsValue(V value) {
        if (this.isEmpty()) {
            return false;
        }
        for (Node<K, V> node: array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean equalsKey(K k1, K k2) {
        // k1, k2 both possibly to be null.
        if (k1 == null && k2 == null) {
            return true;
        } else if (k1 == null || k2 == null) {
            return false;
        }
        return k1.equals(k2);
    }

    public boolean containsKey(K key) {
        // get the index of the key
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /** value will always be non-negative. */
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }
        // append the new node before the head and update the new head
        // insert operation.
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
        if (needRehash()) {
            rehash();
        }
        return null;
    }

    private boolean needRehash() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehash() {
        // new double sized array.
        // for each node in the old array, put to the new larger array.
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        for (Node<K, V> node: oldArray) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = getIndex(node.key);
                node.next = array[index];
                array[index] = node;
                node = next;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            // check if the key equals()
            // key, node.key() both pissible to be null.
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public V remove(K key) {
        // get index.
        // delete operation on the linked list.
        // size--.
        int index = getIndex(key);
        Node<K, V> node = array[index];
        Node<K, V> pre = null;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                if (pre != null) {
                    pre.next = node.next;
                } else {
                    array[index] = node.next;
                }
                size--;
                return node.value;
            }
            pre = node;
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapII<Integer, Integer> myHashMap = new HashMapII<>();
        System.out.println(myHashMap.put(1,1));
        System.out.println(myHashMap.put(2,2));
        System.out.println(myHashMap.get(1));
        System.out.println( myHashMap.get(3));
        System.out.println(myHashMap.put(2,1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.remove(2));
        System.out.println(myHashMap.get(2));
    }
}
