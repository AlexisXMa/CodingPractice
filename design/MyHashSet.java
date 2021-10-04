package design;

/*
705. Design HashSet
 */

import java.util.*;

public class MyHashSet {
    // Method: ArrayList as Bucket
    static class Bucket {
        private List<Integer> bucket;

        public Bucket() {
            this.bucket = new ArrayList<>();
        }

        public void insert(Integer key) {
            boolean found = false;
            for (Integer num: bucket) {
                if (num.equals(key)) {
                    found = true;
                }
            }
            if (!found) {
                bucket.add(key);
            }
        }

        public void delete(Integer key) {
            this.bucket.remove(key);
        }

        public boolean exits(Integer key) {
            return this.bucket.contains(key);
        }
    }

    private List<Bucket> bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 1999;
        this.bucketArray = new ArrayList<>();
        for (int i = 0; i < this.keyRange; i++) {
            this.bucketArray.add(new Bucket());
        }
    }

    private int hash(int key) {
        return key % this.keyRange;
    }

    public void add(int key) {
        int idx = hash(key);
        this.bucketArray.get(idx).insert(key);
    }

    public void remove(int key) {
        int idx = hash(key);
        this.bucketArray.get(idx).delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = hash(key);
        return this.bucketArray.get(idx).exits(key);
    }
}
