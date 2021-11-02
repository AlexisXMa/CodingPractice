package algorithm.slidingWindow;

// 1423. Maximum Points You Can Obtain from Cards

public class MaxPointsFromCards {
    // Method: Sliding Window
    // Time = O(n); Space = O(1)
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalScore = 0;
        for (int point: cardPoints) {
            totalScore += point;
        }

        if (k == n) {
            return totalScore;
        }

        int requiredLen = n - k;
        int curSubarrayScore = 0;
        int minSubarrayScore = totalScore;
        int startIdx = 0;

        for (int i = 0; i < n; i++) {
            curSubarrayScore += cardPoints[i];
            int curLen = i - startIdx + 1;
            if (curLen == requiredLen) {
                minSubarrayScore = Math.min(minSubarrayScore, curSubarrayScore);
                curSubarrayScore -= cardPoints[startIdx];
                startIdx++;
            }
        }
        return totalScore - minSubarrayScore;
    }


    // Method: DP - Space Optimized
    // Time = O(k); Space = O(1)
    public int maxScore2(int[] cardPoints, int k) {
        int frontScore = 0;
        int rearScore = 0;
        int n = cardPoints.length;

        for (int i = 0; i< k; i++) {
            frontScore += cardPoints[i];
        }

        // take all k cards from the beginning
        int maxScore = frontScore;

        // take i cards from the beginning and k - i cards from the end
        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int curScore = frontScore + rearScore;
            maxScore = Math.max(maxScore, curScore);
        }
        return maxScore;
    }
}
