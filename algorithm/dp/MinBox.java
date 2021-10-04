package algorithm.dp;

/*
We will put the swags into square-shaped boxes. Each box has to be completely filled so that the swags
would not break during transportation. For example, a box can contain 1 swag, 4 swags, 9 swags, etc.
Given the number of swags, what is the minimum number of boxes to pack them up?
 */

public class MinBox {
    public int minBox (int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MinBox sol = new MinBox();
        System.out.println(sol.minBox(4)); // expected 1
        System.out.println(sol.minBox(10)); // expected 2
    }

}
