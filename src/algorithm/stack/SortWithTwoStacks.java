package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SortWithTwoStacks {
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        Deque<Integer> s2 = new LinkedList<>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> input, Deque<Integer> buffer) {
        // input: unsorted elements
        // buffer: (top part) buffer, (bottom part) sorted elements
        // Step 1: sort in ascending order and store result in buffer
        while (!input.isEmpty()) {
            int curMin = Integer.MAX_VALUE;
            int count = 0;
            while (!input.isEmpty()) {
                int cur = input.pollFirst();
                if (cur < curMin) {
                    curMin = cur;
                    count = 1;
                } else if (cur == curMin) {
                    count++;
                }
                buffer.offerFirst(cur);
            }
            while(!buffer.isEmpty() && buffer.peekFirst() >= curMin) {
                int temp = buffer.pollFirst();
                if (temp != curMin) {
                    input.offerFirst(temp);
                }
            }
            while (count-- > 0) {
                buffer.offerFirst(curMin);
            }
        }
        // Step 2: move result from buffer to input, so it is in descending order
        while (!buffer.isEmpty()) {
            input.offerFirst(buffer.pollFirst());
        }
    }
}
