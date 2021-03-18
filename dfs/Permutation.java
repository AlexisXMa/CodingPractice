package algorithm.dfs;

/*
Given a string with no duplicate characters, return a list with all permutations of the characters.
Assume that input string is not null.
 */

import java.util.*;

public class Permutation {
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        char[] charArray = input.toCharArray();
        helper(charArray, 0, result);
        return result;
    }

    private void helper(char[] charArray, int index, List<String> result) {
        if (index == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        for (int i = index; i < charArray.length; i++) {
            swap(charArray, index, i);
            helper(charArray, index + 1, result);
            swap(charArray, index, i);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
