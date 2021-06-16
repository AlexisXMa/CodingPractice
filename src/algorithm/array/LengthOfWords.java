package algorithm.array;

/*
Find the length of each word in a string without using split operation.
 */

import java.util.*;

public class LengthOfWords {
    public List<Integer> lengthOfWords (String input) {
        char[] array = input.toCharArray();
        List<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }
        Set<Character> set = new HashSet<>(Arrays.asList(' ', ',', ':', ';', '.', '!'));
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                if (length != 0) {
                    result.add(length);
                    length = 0;
                    continue;
                } else {
                    continue;
                }
            } else if (i == array.length - 1) {
                result.add(++length);
            }
            length++;
        }
        return result;
    }
}
