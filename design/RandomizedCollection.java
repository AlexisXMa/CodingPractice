package design;

/*
381. Insert Delete GetRandom O(1) - Duplicates allowed
 */

import java.util.*;

public class RandomizedCollection {
    // Method: ArrayList + HashMap<Integer, Set<Integer>>
    // Each function works in average O(1) time
    List<Integer> array;
    Map<Integer, Set<Integer>> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.array = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(array.size());
        array.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        int removeIdx =  map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        int lastElement = array.get(array.size() - 1);
        array.set(removeIdx, lastElement);
        map.get(lastElement).add(removeIdx);
        // remove the last element and its index
        map.get(lastElement).remove(array.size() - 1);
        array.remove(array.size() - 1);
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomIdx = random.nextInt(array.size());
        return array.get(randomIdx);
    }
}
