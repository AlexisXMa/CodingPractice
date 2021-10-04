package algorithm.graph;

// 277. Find the Celebrity

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindCelebrity {
    // Method: Two Pass
    // Time = O(n); Space = O(1)
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // 1. If knows(candidate, i) == true, then candidate cannot be the
            // celebrity because the real celebrity cannot know anyone.
            // 2. If knows(candidate, i) == false, then i cannot be the celebrity
            // because all others know the real celebrity
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            // 1. Check whether all others know the candidate
            if (candidate != i && !knows(i, candidate)) {
                return -1;
            }

            // 2. Check whether the candidate knows anyone
            if (candidate != i && knows(candidate, i)) {
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int a, int b) {
        return true;
    }
}
