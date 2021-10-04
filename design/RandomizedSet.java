package design;

/*
380. Insert Delete GetRandom O(1)
 */

import java.util.*;

public class RandomizedSet {
    // Method: HashMap + ArrayList
    // Each function works in average O(1) time
    Map<Integer, Integer> map;
    List<Integer> array;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.array = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, array.size());
        array.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = array.get(array.size() - 1);
        int idx = map.get(val);
        array.set(idx, lastElement);
        map.put(lastElement, idx);
        // delete the last element from array
        array.remove(array.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randomIdx = random.nextInt(array.size());
        return array.get(randomIdx);
    }
}