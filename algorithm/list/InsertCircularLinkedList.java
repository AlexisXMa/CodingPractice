package algorithm.list;

/*
Given an integer and a ListNode in a sorted circular LinkedList, insert a new node to this LinkedList.
Although the LinkedList is sorted, the given node could be any node in it.
 */

public class InsertCircularLinkedList {
    public ListNode insert(ListNode head, int newVal) {
        ListNode newNode = new ListNode(newVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode cur = head;
        ListNode nxt = head.next;
        while (nxt != head) {
            // 1. min_value <= target <= max_value
            if (cur.value <= nxt.value) {
                if (cur.value <= newVal && newVal <= nxt.value) {
                    break;
                }
            } else { // 2. target < minValue || target > max_value
                if (cur.value <= newVal || nxt.value >= newVal) {
                    break;
                }
            }
            cur = cur.next;
            nxt = nxt.next;
        }
        newNode.next = nxt;
        cur.next = newNode;
        return head;
    }
}
