package algorithm.search;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions
There are no duplicate characters in the original set.
 */

import java.util.*;

public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        helper(result, new StringBuilder(), arraySet, k, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder cur, char[] arraySet, int k, int index) {
        // after picked k elements, we add it to the result and return
        if (cur.length() == k) {
            result.add(new String(cur));
            return;
        }
        // when we finish with all characters, we must return
        if (index == arraySet.length) {
            return;
        }
        // 1. pick the character at index
        cur.append(arraySet[index]);
        helper(result, cur, arraySet, k, index + 1);
        cur.deleteCharAt(cur.length() - 1);
        // 2. not pick the character at index
        helper(result, cur, arraySet, k, index + 1);
    }
}
