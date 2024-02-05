package leetcode.linkedList.easy;

import leetcode.linkedList.LinkedList;
import leetcode.linkedList.ListNode;

public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(new int[]{1, 2, 4});
        LinkedList list2 = new LinkedList(new int[]{1, 3, 4});
        ListNode head = mergeTwoLists(list1.head, list2.head);
        System.out.println("Non-recursive: ");
        head.printFromHead();
        LinkedList list3 = new LinkedList(new int[]{1, 2, 4});
        LinkedList list4 = new LinkedList(new int[]{1, 3, 4});
        ListNode head2 = mergeTwoLists(list3.head, list4.head);
        System.out.println();
        System.out.println("Recursive: ");
        head2.printFromHead();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode prev = root;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if (list2 != null) {
            prev.next = list2;
        }
        if (list1 != null) {
            prev.next = list1;
        }
        return root.next;
    }

     public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
         if (list1 == null) {
             return list2;
         }
         if (list2 == null) {
             return list1;
         }
         if (list1.val < list2.val) {
             list1.next = mergeTwoLists(list1.next, list2);
             return list1;
         } else {
             list2.next = mergeTwoLists(list2.next, list1);
             return list2;
         }
     }
}
