package algorithm.string;

// 1592. Rearrange Spaces Between Words

public class RearrangeSpacesBetweenWords {
    // Method: One Pass
    // Time = O(n); Space = O(n)
    public String reorderSpaces(String text) {
        // Count total number of spaces
        int numSpaces = 0;
        for (char c: text.toCharArray()) {
            if (c == ' ') {
                numSpaces++;
            }
        }

        // Split text and get total number of words
        String[] words = text.trim().split("\\s+");
        int numWords = words.length;

        // numSpaces / (numWords - 1) spaces per interval
        // numSpaces % (numWords - 1) for end word (possibly 0)
        int midSpaces = 0;
        int endSpaces = 0;
        if (numWords == 1) {
            endSpaces = numSpaces;
        } else {
            midSpaces = numSpaces / (numWords - 1);
            endSpaces = numSpaces % (numWords - 1);
        }

        StringBuilder sb = new StringBuilder();
        // Append words and midSpaces
        // If numWords = 1, we skip this part
        for (int i = 0; i < numWords - 1; i++) {
            sb.append(words[i]);
            for (int j = 0; j < midSpaces; j++) {
                sb.append(" ");
            }
        }

        // Append last word and endSpaces
        sb.append(words[numWords - 1]);
        for (int j = 0; j < endSpaces; j++) {
            sb.append(" ");
        }

        return new String(sb);
    }
}
