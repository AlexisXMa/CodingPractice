package algorithm.slidingWindow;

// 1610. Maximum Number of Visible Points

import java.util.*;

public class MaxNumberOfVisiblePoints {
    // Method: Sliding Window
    // Time = O(n log n)
    // Space = O(n)
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> point: points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            // If it is a same point as location
            if (dx == 0 && dy == 0) {
                count++;
                continue;
            }
            double theta = Math.atan2(dx, dy);
            angles.add(theta * (180 / Math.PI));
        }

        Collections.sort(angles);

        List<Double> fullAngles = new ArrayList<>(angles);
        // concatenate to handle edge case
        for (double d: angles) {
            fullAngles.add(d + 360);
        }

        int left = 0;
        int right = 0;
        int result = count;
        while (right < fullAngles.size()) {
            if (fullAngles.get(right) - fullAngles.get(left) > angle) {
                left++;
            } else {
                result = Math.max(result, count + right - left + 1);
                right++;
            }
        }
        return result;
    }
}
