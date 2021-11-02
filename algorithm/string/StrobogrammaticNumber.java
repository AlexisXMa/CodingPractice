package algorithm.string;

// 246. Strobogrammatic Number

import java.util.*;

public class StrobogrammaticNumber {
    // Method: Two Pointers
    // Time = O(n); Space = O(1)
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            int leftNum = num.charAt(left++) - '0';
            int rightNum = num.charAt(right--) - '0';
            if (map.getOrDefault(leftNum, -1) != rightNum) {
                return false;
            }
        }
        return true;
    }
}
