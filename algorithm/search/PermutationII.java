package algorithm.search;

/*
Given a string with possible duplicate characters,
return a list with all permutations of the characters.
 */

import java.util.*;

public class PermutationII {
    public List<String> permutation(String input) {
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        char[] array = input.toCharArray();
        helper(array, result, 0);
        return result;
    }

    private void helper(char[] array, List<String> result, int index) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // Rule: for the current level, if a certain element is picked, we cannot
        // pick any of its duplicates
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, index, i);
                helper(array, result, index + 1);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        PermutationII sol = new PermutationII();
        System.out.println(sol.permutation("aba"));
    }
}
