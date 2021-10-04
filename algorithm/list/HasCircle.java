package algorithm.list;

/*
Check if a given linked list has a cycle. Return true if it does, otherwise return false.

Assumption:
You can assume there is no duplicate value appear in the linked list.
 */

public class HasCircle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
