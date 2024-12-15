package com.korn;

import java.util.Objects;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

/**
 * Solution for <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {
    public ListNode mergeKListsWithDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int maxIndex = lists.length - 1;
        while (maxIndex > 0) {
            int toInsertIndex = 0;
            for (int i = 0; i <= maxIndex; i += 2) {
                ListNode node = i < maxIndex ? mergeTwoNodes(lists[i], lists[i + 1]) : lists[i];
                lists[toInsertIndex] = node;
                toInsertIndex++;
            }
            maxIndex = toInsertIndex - 1;
        }

        return lists[0];
    }

    private ListNode mergeTwoNodes(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }

        return dummy.next;
    }

    public ListNode mergeKListsWithHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(comparingInt(listNode -> listNode.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            if (current.next != null) {
                heap.add(current.next);
            }
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }
    }
}
