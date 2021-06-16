package algorithm.string;

// Reverse a given string.

public class ReverseString {
    // Method 1: iterative reverse
    // Time = O(n); Space = O(1)
    public String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    // Method 2: recursive reverse
    // Time = O(n); Space = O(n)
    public String reverse2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        return reverseHelper(array, 0, array.length - 1);
    }

    private String reverseHelper(char[] array, int left, int right) {
        if (left >= right) {
            return new String(array);
        }
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
        return reverseHelper(array, left + 1, right - 1);
    }
}
