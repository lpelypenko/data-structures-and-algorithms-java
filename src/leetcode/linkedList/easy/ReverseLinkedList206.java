package leetcode.linkedList.easy;

import leetcode.linkedList.LinkedList;
import leetcode.linkedList.ListNode;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        LinkedList test = new LinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Before the reverse: ");
        test.printList();
        ListNode newHead = reverseList(test.head);
        System.out.println("After the reverse: ");
        test.printList();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
