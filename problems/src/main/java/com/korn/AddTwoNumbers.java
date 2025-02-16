package com.korn;

import com.korn.model.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        boolean overflow = false;
        while (l1 != null && l2 != null) {
            int tempSum = l1.val + l2.val + (overflow ? 1 : 0);
            current.next = new ListNode(tempSum % 10);
            current = current.next;
            overflow = tempSum > 9;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int tempSum = l1.val + (overflow ? 1 : 0);
            current.next = new ListNode(tempSum % 10);
            current = current.next;
            overflow = tempSum > 9;
            l1 = l1.next;
        }

        while (l2 != null) {
            int tempSum = l2.val + (overflow ? 1 : 0);
            current.next = new ListNode(tempSum % 10);
            current = current.next;
            overflow = tempSum > 9;
            l2 = l2.next;
        }

        if (overflow) {
            current.next = new ListNode(1);
        }

        return dummy.next;
    }
}
