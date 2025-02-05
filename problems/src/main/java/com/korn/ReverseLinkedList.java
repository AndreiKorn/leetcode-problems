package com.korn;

import com.korn.model.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
