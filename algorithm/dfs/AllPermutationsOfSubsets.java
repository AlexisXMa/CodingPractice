package algorithm.dfs;

/*
Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.
 */

import java.util.*;

public class AllPermutationsOfSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        helper(result, arraySet, 0);
        return result;
    }

    // choose the character to be at the position of "index" from the subarray of [index, array.length - 1]
    // all the already chosen positions are [0, index - 1]
    private void helper(List<String> result, char[] array, int index) {
        // every state in the recursion tree is a valid result
        result.add(new String(array, 0, index));
        // all the possible characters could be placed at index are
        // the characters in the subarray [index, array.length - 1]
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(result, array, index + 1);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
