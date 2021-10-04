package algorithm.list;

/*
Merge two sorted lists into one large sorted list.
 */

public class MergeLinkedList {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        // link the remaining possible nodes
        if (one != null) {
            cur.next = one;
        } else if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }

}
