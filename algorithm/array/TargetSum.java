package algorithm.array;

// 494. Target Sum

public class TargetSum {
    // Method: 2d DP
    // Time = O(tn); Space = O(tn)
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num: nums) {
            total += num;
        }

        // Sanity check
        if (Math.abs(target) > total) {
            return 0;
        }

        // dp[i][j + total] := whether we can get sum of j using numbers in nums[0, i]
        int[][] dp = new int[nums.length][2 * total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][- nums[0] + total] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = - total; sum <= total; sum++) {
                if (dp[i - 1][sum + total] > 0) {
                    dp[i][sum + nums[i] + total] += dp[i - 1][sum + total];
                    dp[i][sum - nums[i] + total] += dp[i - 1][sum + total];
                }
            }
        }
        return dp[nums.length - 1][total + target];
    }
}
