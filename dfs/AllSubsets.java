package algorithm.dfs;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions
There are no duplicate characters in the original set.
 */

import java.util.*;

public class AllSubsets {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        helper(result, arraySet, new StringBuilder(), 0);
        return result;
    }

    private void helper(List<String> result, char[] array, StringBuilder cur, int index) {
        if (index == array.length) {
            result.add(new String(cur));
            return;
        }
        // 1. pick the character at index
        cur.append(array[index]);
        helper(result, array, cur, index + 1);
        cur.deleteCharAt(cur.length() - 1);
        // 2. not pick the character at index
        helper(result, array, cur, index + 1);
    }
}
