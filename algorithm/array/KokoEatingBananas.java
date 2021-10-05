package algorithm.array;

// 875. Koko Eating Bananas

public class KokoEatingBananas {
    // Method: Binary Search
    // n = length of piles
    // M = largest element in piles
    // Time = O(n log M)
    // Space = O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (canEatAll(piles, left, h)) {
            return left;
        }
        return right;
    }

    private boolean canEatAll(int[] piles, int k, int h) {
        int totalHours = 0;
        for (int pile: piles) {
            totalHours += pile / k;
            if (pile % k != 0) {
                totalHours++;
            }
        }
        return totalHours <= h;
    }

    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
