package com.korn;

import com.korn.model.MultiLevelDoublyLinkedNode;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/">Flatten a Multilevel Doubly Linked List</a>
 */
public class FlattenAMultilevelDoublyLinkedList {
    public MultiLevelDoublyLinkedNode flatten(MultiLevelDoublyLinkedNode head) {
        if (head == null) {
            return null;
        }
        flattenInner(head);
        return head;
    }

    private MultiLevelDoublyLinkedNode flattenInner(MultiLevelDoublyLinkedNode parent) {
        while (parent.next != null || parent.child != null) {
            if (parent.child != null) {
                MultiLevelDoublyLinkedNode next = parent.next;
                parent.next = parent.child;
                parent.next.prev = parent;
                parent.child = null;
                parent = flattenInner(parent.next);
                parent.next = next;
                if (next != null) {
                    next.prev = parent;
                }
            } else {
                parent = parent.next;
            }
        }
        return parent;
    }
}
