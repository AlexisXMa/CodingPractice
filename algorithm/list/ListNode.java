package algorithm.list;

public class ListNode {
    int value;
    ListNode next;
    ListNode (int value) {
        this.value = value;
        this.next = null;
    }
    ListNode (int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
