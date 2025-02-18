package com.korn;

import com.korn.model.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/sort-list/">Sort List</a>
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left == null ? right : left;
        return dummy.next;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = null;
        while (head != null && head.next != null) {
            slow = (slow == null) ? head : slow.next;
            head = head.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }
}
