package algorithm.math;

// 504. Base 7

public class Base7 {
    // Method: Iteration
    // Time = O(log n); Space = O(1)
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            negative = true;
            num = -num;
        }
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (negative) {
            sb.append('-');
        }
        return new String(sb.reverse());
    }
}
