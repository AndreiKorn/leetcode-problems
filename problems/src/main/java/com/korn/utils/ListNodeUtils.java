package com.korn.utils;

import com.korn.model.ListNode;

public class ListNodeUtils {
    private ListNodeUtils() {
    }

    public static ListNode[] createLists(int[]... values) {
        ListNode[] lists = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            lists[i] = createList(values[i]);
        }
        return lists;
    }

    public static ListNode createList(int... values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode createListWithCycle(int[] values, int position) {
        if (values.length <= position) {
            throw new IllegalArgumentException(
                    "Cycle element position is out of boundaries. List length: " + values.length
                            + ", position: " + position
            );
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        ListNode cycleNode = null;
        for (int i = 0; i < values.length; i++) {
            ListNode nextNode = new ListNode(values[i]);
            current.next = nextNode;
            current = nextNode;
            if (i == position) {
                cycleNode = current;
            }
        }
        current.next = cycleNode;

        return dummy.next;
    }
}
