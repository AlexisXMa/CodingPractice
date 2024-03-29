package algorithm.list;

/*
Reverse pairs of elements in a singly-linked list.
 */

public class ReverseLinkedListInPairs {
    // Method 1: recursion
    public ListNode reverseInPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = reverseInPairs1(head.next.next);
        newHead.next = head;
        return newHead;
    }

    // Method 2: iterative
    public ListNode reverseInPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }

}
