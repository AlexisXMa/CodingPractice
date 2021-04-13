package algorithm.dfs;

/*
Given a set of characters represented by a String, return a list containing all subsets of
the characters whose size is K. Notice that each subset returned will be sorted for deduplication.

Assumptions
There could be duplicate characters in the original set.
 */

import java.util.*;

public class AllSubsetsOfSizeKII {
    public List<String> subSetsOfSizeK2(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // sort the char array so that we can dedup
        Arrays.sort(arraySet);
        helper(result, new StringBuilder(), arraySet, k, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder cur, char[] arraySet, int k, int index) {
        if (cur.length() == k) {
            result.add(new String(cur));
            return;
        }
        if (index == arraySet.length) {
            return;
        }
        // 1. pick the character at the index
        helper(result, cur.append(arraySet[index]), arraySet, k, index + 1);
        cur.deleteCharAt(cur.length() - 1);
        // skip all the consecutive and duplicate elements
        while (index + 1 < arraySet.length && arraySet[index] == arraySet[index + 1]) {
            index++;
        }
        // 2. not pick the character at the index
        helper(result, cur, arraySet, k, index + 1);
    }
}
