package algorithm.string;

// 1790. Check if One String Swap Can Make Strings Equal

import java.util.*;

public class CheckIfEqualByOneSwap {
    // Solution: One pass
    // Time = O(n); Space = O(1)
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> mismatches = new ArrayList<>();
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatches.add(i);
            }
            // Added this check to short circuit the loop
            if (mismatches.size() > 2) {
                return false;
            }
        }

        if (mismatches.size() == 0) {
            return true;
        } else if (mismatches.size() == 2
                && s1.charAt(mismatches.get(0)) == s2.charAt(mismatches.get(1))
                && s1.charAt(mismatches.get(1)) == s2.charAt(mismatches.get(0))) {
            return true;
        }
        return false;
    }
}
