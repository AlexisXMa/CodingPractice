package algorithm.dp;

// 552. Student Attendance Record II

public class StudentAttendanceRecordII {
    // Method: DP
    // Time = O(n); Space = O(n)
    public int checkRecord(int n) {
        // dp00[i]: for s[0, i] A never appeared, ending with 0 L
        long[] dp00 = new long[n + 1];
        // dp01[i]: for s[0, i] A never appeared, ending with 1 L
        long[] dp01 = new long[n + 1];
        // dp02[i]: for s[0, i] A never appeared, ending with 2 L
        long[] dp02 = new long[n + 1];
        // dp10[i]: for s[0, i] A appeared once, ending with 0 L
        long[] dp10 = new long[n + 1];
        // dp11[i]: for s[0, i] A appeared once, ending with 1 L
        long[] dp11 = new long[n + 1];
        // dp12[i]: for s[0, i] A appeared once, ending with 2 L
        long[] dp12 = new long[n + 1];

        // Base Case
        dp00[0] = 1;

        long mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            dp00[i] = (dp00[i - 1]  + dp01[i - 1] + dp02[i - 1]) % mod;
            dp01[i] = dp00[i - 1];
            dp02[i] = dp01[i - 1];
            dp10[i] = (dp00[i - 1] + dp01[i - 1] + dp02[i - 1] + dp10[i - 1]  + dp11[i - 1] + dp12[i - 1]) % mod;
            dp11[i] =  dp10[i - 1];
            dp12[i] = dp11[i - 1];
        }
        return (int)((dp00[n] + dp01[n] + dp02[n] + dp10[n] + dp11[n] + dp12[n]) % mod);
    }
}
