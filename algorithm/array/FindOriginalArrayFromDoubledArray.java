package algorithm.array;

// 2007. Find Original Array From Doubled Array

import java.util.*;

public class FindOriginalArrayFromDoubledArray {
    // Method: Sort + HashMap
    // Time = O(n log n); Space = O(n)
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len == 0 || len % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        int[] result = new int[len / 2];
        int idx = 0;
        int i = len - 1;
        while (i >= 0) {
            int num = changed[i--];
            int twice = num * 2;
            if (map.containsKey(twice)) {
                if (map.get(twice) == 1) {
                    map.remove(twice);
                } else {
                    map.put(twice, map.get(twice) - 1);
                }
                result[idx++] = num;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return map.size() == 0 ? result : new int[0];
        // return idx == len / 2 ? result : new int[0];
    }

    public static void main (String[] args) {
        // The elements in original may be returned in any order.
        FindOriginalArrayFromDoubledArray sol = new FindOriginalArrayFromDoubledArray();

        int[] array1 = new int[]{ 1,3,4,2,6,8 };
        int[] result1 = sol.findOriginalArray(array1);
        System.out.println(Arrays.toString(result1));   // Output: [1,3,4]

        int[] array2 = new int[]{ 6,3,0,1 };
        int[] result2 = sol.findOriginalArray(array2);
        System.out.println(Arrays.toString(result2));   // Output: []
    }
}
