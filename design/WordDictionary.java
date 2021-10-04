package design;

/*
211. Design Add and Search Words Data Structure
 */

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
}


public class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
        }
        cur.isWord = true;
    }


    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    /** Returns if the word is in the node. */
    private boolean searchInNode(String word, TrieNode node) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = cur.children.get(c);
            if (next == null) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (c == '.') {
                    for (char x: cur.children.keySet()) {
                        TrieNode child = cur.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                cur = next;
            }
        }
        return cur.isWord;
    }
}
