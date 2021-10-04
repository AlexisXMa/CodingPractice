package algorithm.trie;

import java.util.*;

public class TrieNode {
    Map<Character, TrieNode> children;
    // or we can use: --> index: char - 'a'
    // TrieNode[] children;
    boolean isWord;
    int count;
}
