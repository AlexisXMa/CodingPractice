package algorithm.list;

/*
Insert a value in a sorted linked list.
 */

public class InsertSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // 1. insert before the head
        if (head == null || value <= head.value) {
            newNode.next = head;
            return newNode;
        }
        // 2. insert the new node to the right position
        ListNode cur = head;
        while (cur.next != null && cur.next.value < value) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }
}
