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
}
