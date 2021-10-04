package algorithm.list;

/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null
to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null.
 */

public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = reverse(mid.next);
        mid.next = null;   // break into two linked lists
        return merge(one, two);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }
}
