package com.korn.model;

import java.util.Objects;
import java.util.StringJoiner;

public class MultiLevelDoublyLinkedNode {
    public final int val;
    public MultiLevelDoublyLinkedNode prev;
    public MultiLevelDoublyLinkedNode next;
    public MultiLevelDoublyLinkedNode child;

    public MultiLevelDoublyLinkedNode(
            int val,
            MultiLevelDoublyLinkedNode prev,
            MultiLevelDoublyLinkedNode next,
            MultiLevelDoublyLinkedNode child
    ) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    private boolean ensureDoublyLinked() {
        if (prev != null) {
            return prev.next == this;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MultiLevelDoublyLinkedNode that = (MultiLevelDoublyLinkedNode) o;
        return val == that.val
                && ensureDoublyLinked()
                && Objects.equals(next, that.next)
                && Objects.equals(child, that.child);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MultiLevelDoublyLinkedNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("prev=" + (prev == null ? null : prev.val))
                .add("next=" + next)
                .add("child=" + child)
                .toString();
    }
}
