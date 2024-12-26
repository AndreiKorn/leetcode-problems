package com.korn;

import com.korn.model.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        return slow == fast;
    }
}
