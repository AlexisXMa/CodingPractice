package algorithm.string;

/*
Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string,
the other characters should not be moved or changed.
Assumptions:
The given string is not null, and only contains lower case letters.
 */

import java.util.*;

public class ReverseVowels {
    public String reverse(String input) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'i'));
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            while(left < right && !set.contains(array[left])) {
                left++;
            }
            while(left < right && !set.contains(array[right])) {
                right--;
            }
            char tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
        return new String(array);
    }
}
