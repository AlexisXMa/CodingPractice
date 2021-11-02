package algorithm.string;

// 792. Number of Matching Subsequences

import java.util.*;

public class NumberOfMatchingSubsequences {
    // Method: Next Letter Pointers + HashMap
    // L1 = length of s
    // n = number of words
    // L2 = sum length of all words
    // Time = O(L1 + L2)
    // Space = O(L2)
    static class Node {
        String word;
        int index;
        Node (String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Node>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String word: words) {
            char startingChar = word.charAt(0);
            Node cur = new Node(word, 0);
            buckets[startingChar - 'a'].add(cur);
        }

        int result = 0;
        for (char c: s.toCharArray()) {
            ArrayList<Node> curBucket = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();
            for (Node node: curBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    result++;
                } else {
                    char startingChar = node.word.charAt(node.index);
                    buckets[startingChar - 'a'].add(node);
                }
            }
        }
        return result;
    }
}
