package algorithm.string;

// 843. Guess the Word

import java.util.*;

public class GuessTheWord {
    // Method: Guess a Random Word
    // Time = O(n); Space = O(n)
    public void findSecretWord(String[] wordlist, Master master) {
        int n = 10;     // number of guesses
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIdx = random.nextInt(wordlist.length);
            String guess = wordlist[randomIdx];
            int numOfMatches = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String string: wordlist) {
                if (match(guess, string) == numOfMatches) {
                    wordlist2.add(string);
                }
            }
            wordlist = wordlist2.toArray(new String[0]);
        }
    }

    private int match(String s1, String s2) {
        int numOfMatches = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                numOfMatches++;
            }
        }
        return numOfMatches;
    }
}
