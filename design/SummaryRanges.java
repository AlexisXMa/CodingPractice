package design;

/*
352. Data Stream as Disjoint Intervals
 */

import java.util.*;

public class SummaryRanges {
    // Use TreeMap to easily find the lower and higher keys,
    // the key is the start of the interval.
    // Merge the lower and higher intervals when necessary.
    // Time = O(log n)
    TreeMap<Integer, int[]> tree;

    public SummaryRanges() {
        this.tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) {
            return;
        }
        Integer low = tree.lowerKey(val);
        Integer high = tree.higherKey(val);
        if (low != null && high != null
                && tree.get(low)[1] + 1 == val && high == val + 1) {
            tree.get(low)[1] = tree.get(high)[1];
            tree.remove(high);
        } else if (low != null && tree.get(low)[1] + 1 >= val) {
            tree.get(low)[1] = Math.max(tree.get(low)[1], val);
        } else if (high != null && high == val + 1) {
            tree.put(val, new int[]{val, tree.get(high)[1]} );
            tree.remove(high);
        } else {
            tree.put(val, new int[]{val, val} );
        }
    }

    public int[][] getIntervals() {
        return tree.values().toArray(new int[0][0]);
    }
}
