package design;

/*
729. My Calendar I
 */

import java.util.*;

public class MyCalendarI {
    // n = the number of events booked
    // Time = O(n^2)
    // Space = O(n)
    private List<int[]> calendar;

    public MyCalendarI() {
        this.calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] interval: calendar) {
            // For two events [s1, e1) and [s2, e2), they do not conflict IFF one of them starts
            // after the other one ends: either e1 <= s2 OR e2 <= s1.
            // Two events conflict when s1 < e2 AND s2 < e1.
            if (end <= interval[0] || interval[1] <= start) {
                continue;
            } else {
                return false;
            }
        }
        calendar.add(new int[]{ start, end });
        return true;
    }
}
