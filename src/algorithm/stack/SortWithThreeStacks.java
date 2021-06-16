package algorithm.stack;

import java.util.LinkedList;

public class SortWithThreeStacks {
    public void sort(LinkedList<Integer> s1) {
        // s1 = input, s2 = buffer, s3 = result
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        // 1. Shuffle all integers in s1 to s2, record the minimum of s1.
        // 2. Shuffle all integers except the min back to s1, put min to s3.
        // 3. Keep doing 1 & 2 until s1 is empty.
        while (!s1.isEmpty()) {
            int min = Integer.MAX_VALUE;
            while (!s1.isEmpty()) {
                int cur = s1.pollFirst();
                min = cur < min ? cur : min;
                s2.offerFirst(cur);
            }
            while (!s2.isEmpty()) {
                int cur = s2.pollFirst();
                if (cur == min) {
                    s3.offerFirst(cur);
                } else {
                    s1.offerFirst(cur);
                }
            }
        }
        // 4. Shuffle all integers in s3 back to s1.
        // Now, s1 has the sorted integers in the required order.
        while(!s3.isEmpty()) {
            s1.offerFirst(s3.pollFirst());
        }
    }
}
