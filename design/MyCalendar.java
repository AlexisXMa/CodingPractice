package design;

/*
729. My Calendar I
 */

import java.util.TreeMap;

public class MyCalendar {
    // Time = O(n log n ); for each new event, we search that the event is legal in O(logN) time,
    // then insert it in O(1) time.
    //Space = O(n) for the size of the data structures used.
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        this.calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Get the greatest previous start time that is less or equal to this start time.
        Integer prev = calendar.floorKey(start);
        // Get the smallest previous start time that is greater or equal to this start time.
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
