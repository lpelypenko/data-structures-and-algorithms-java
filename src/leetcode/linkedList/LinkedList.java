package leetcode.linkedList;

public class LinkedList {

    public ListNode head;
    public ListNode tail;
    private int length;


    public LinkedList(int value) {
        ListNode newListNode = new ListNode(value);
        head = newListNode;
        tail = newListNode;
        length = 1;
    }

    public LinkedList(int input[]) {
        ListNode newListNode = new ListNode(input[0]);
        head = newListNode;
        tail = newListNode;
        length = 1;
        for (int i = 1; i < input.length; i++) {
            append(input[i]);
        }
    }

    public void append(int value) {
        ListNode newListNode = new ListNode(value);
        if (length == 0) {
            head = newListNode;
            tail = newListNode;
        } else {
            tail.next = newListNode;
            tail = newListNode;
        }
        length++;
    }

    public ListNode removeLast() {
        ListNode temp = head;
        ListNode pre = head;
        if (length == 0) return null;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.val);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.val);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

}
