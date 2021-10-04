package algorithm.dfs;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.
Notice that each subset returned will be sorted to remove the sequence.

Assumptions
There could be duplicate characters in the original set.
 */

import java.util.*;

public class AllSubSetsII {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // make sure the set is sorted so that we can dedup
        Arrays.sort(arraySet);
        helper(result, new StringBuilder(), arraySet, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder cur, char[] arraySet, int index) {
        if (index == arraySet.length) {
            result.add(new String(cur));
            return;
        }
        helper(result, cur.append(arraySet[index]), arraySet, index + 1);
        cur.deleteCharAt(cur.length() - 1);
        // skip all the consecutive and duplicate elements
        while (index < arraySet.length - 1 && arraySet[index] == arraySet[index + 1]) {
            index++;
        }
        helper(result, cur, arraySet, index + 1);
    }
}
