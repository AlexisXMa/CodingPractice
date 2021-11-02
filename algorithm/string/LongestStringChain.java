package algorithm.string;

// 1048. Longest String Chain

import java.util.*;

public class LongestStringChain {
    // Method: DP
    // n = length of words
    // L = maximum length of word
    // Time = O(n (logn + L^2))
    // Space = O(n)
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int longest = 0;
        for (String word: words) {
            int curLongest = 1;
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                curLongest = Math.max(curLongest, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, curLongest);
            longest = Math.max(longest, curLongest);
        }
        return longest;
    }
}
