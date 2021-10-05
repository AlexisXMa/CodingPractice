package algorithm.string;

// Largest palindrome by changing at most K-digits

public class LargestPalindromeChangingAtMostK {
    // Method: Two Pointers
    // Time = O(n); Space = O(n)
    public String largestPalindrome(String s, int k) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            // Replace left or right character by maximum of them
            if (array[left] != array[right]) {
                char max = (char)Math.max(array[left], array[right]);
                array[left] = max;
                array[right] = max;
                k--;
            }
            left++;
            right--;
        }

        // If k < 0, we cannot make the string a palindrome by changing k digits
        if (k < 0) {
            return "Not Possible";
        }

        if (k == 0) {
            return new String(array);
        }

        left = 0;
        right = array.length - 1;
        while (left <= right) {
            if (left == right && k > 0) {
                array[left] = '9';
            }

            if (array[left] < '9') {
                // If k >= 2 and both digits are not changed earlier
                if (k >= 2 && array[left] != s.charAt(left)
                        && array[right] != s.charAt(right)) {
                    k -= 2;
                    array[left] = '9';
                    array[right] = '9';
                }
                // If k >= 1 and one of them is changed earlier
                else if (k >= 1 && (array[left] != s.charAt(left)
                        || array[right] != s.charAt(right))){
                    k -= 1;
                    array[left] = '9';
                    array[right] = '9';
                }
            }

            left++;
            right--;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        LargestPalindromeChangingAtMostK sol = new LargestPalindromeChangingAtMostK();
        System.out.println(sol.largestPalindrome("43435", 3));      // "93939"
        System.out.println(sol.largestPalindrome("43435", 1));      // “53435”
        System.out.println(sol.largestPalindrome("12345", 1));      // "Not Possible"
    }
}
