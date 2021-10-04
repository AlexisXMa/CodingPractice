package algorithm.string;

// 299. Bulls and Cows

public class BullsAndCows {
    // Method: HashMap
    // Time = O(n); Space = O(1)
    public String getHint(String secret, String guess) {
        int bulls = 0;  // A
        int cows = 0;   // B
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < secretCount.length; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
