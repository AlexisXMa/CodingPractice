package algorithm.string;

/*
Determine if a small string is a substring of another large string.
Return the index of the first occurrence of the small string in the large string.
Return -1 if the small string is not a substring of the large string.
 */

public class IfSubstring {
    // Method 1, Time = O(n^2)
    public int strstr(String large, String small) {
        if (large == null || small == null || large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            int j = 0;
            while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
                j++;
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }
}
