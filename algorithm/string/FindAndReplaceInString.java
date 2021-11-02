package algorithm.string;

// 833. Find And Replace in String

import java.util.*;

public class FindAndReplaceInString {
    // Method: One Pass
    // Time = O(n^2)
    // Space = O(n)
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // 1. Create an indices map. Sort the indices to process from left to right.
        Map<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indicesMap.put(indices[i], i);
        }
        Arrays.sort(indices);

        // 2. For each index, check for validity, append the changes
        StringBuilder sb = new StringBuilder();
        int curIdx = 0;
        for (int index: indices) {
            int i = indicesMap.get(index);
            int nextIdx = index + sources[i].length();
            if (s.substring(index, nextIdx).equals(sources[i])) {
                sb.append(s.substring(curIdx, index));
                sb.append(targets[i]);
                curIdx = nextIdx;
            }
        }

        // 3. Last, append the remaining substring
        sb.append(s.substring(curIdx));
        return new String(sb);
    }
}
