package algorithm.list;

/*
Reverse a singly-linked list.
 */

public class ReverseLinkedList {
    // Method 1: Iterative Method
    // Time = O(n); Space = O(1)
    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;		// store the sub-head
            cur.next = pre;                 // reverse happens here
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    // Method 2: Recursion Method
    // Time = O(n); Space = O(n)
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
