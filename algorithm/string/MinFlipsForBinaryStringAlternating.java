package algorithm.string;

// 1888. Minimum Number of Flips to Make the Binary String Alternating

public class MinFlipsForBinaryStringAlternating {
    // Method 1: Sliding Window
    // Time = O(n); Space = O(n)
    public int minFlips(String s) {
        int n = s.length();
        char[] sChars = new char[n * 2];
        for (int i = 0; i < n * 2; i++) {
            sChars[i] = s.charAt(i % n);
        }

        char[] chars1 = new char[n * 2];
        char[] chars2 = new char[n * 2];
        for (int i = 0; i < n * 2; i++) {
            // chars1 = "01010..."
            chars1[i] = i % 2 == 0 ? '0' : '1';
            // chars2 = "10101..."
            chars2[i] = i % 2 == 0 ? '1' : '0';
        }

        int result = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n * 2; i++) {
            // If cur chars are not equal, increase the mismatch count
            if (sChars[i] != chars1[i])  { count1++; }

            if (sChars[i] != chars2[i]) { count2++; }

            // If the sliding window exceeds the size of n, remove the leftmost mismatch count
            if (i >= n) {
                if (sChars[i - n] != chars1[i - n])  { count1--; }
                if (sChars[i - n] != chars2[i - n])  { count2--; }
            }

            // If the sliding window reaches the size of n, update the result
            if (i >= n - 1) {
                result = Math.min(result, Math.min(count1, count2));
            }
        }
        return result;
    }


    // Method: Optimized Sliding Window
    // Time = O(n); Space = O(1)
    public int minFlips2(String s) {
        int n = s.length();
        int result = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            char charInS = s.charAt(i % n);
            // charAlterStartWith0 := represents a char in "01010..."
            char charAlterStartWith0 = i % 2 == 0 ? '0' : '1';
            if (charInS != charAlterStartWith0) {
                count1++;
            } else {
                count2++;
            }

            if (i >= n) {
                int leftIdx = i - n;
                char char0 = leftIdx % 2 == 0 ? '0' : '1';
                if (char0 != s.charAt(leftIdx)) {
                    count1--;
                } else {
                    count2--;
                }

                result = Math.min(result, Math.min(count1,  count2));
            }
        }
        return result;
    }
}
