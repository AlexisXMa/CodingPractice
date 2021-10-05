package algorithm.string;

// 551. Student Attendance Record I

public class StudentAttendanceRecordI {
    // Method: One Pass
    // Time = O(n); Space = O(1)
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA >= 2) return false;
            }
            if (i <= s.length() - 3 && s.charAt(i) == 'L'
                    && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return true;
    }
}
