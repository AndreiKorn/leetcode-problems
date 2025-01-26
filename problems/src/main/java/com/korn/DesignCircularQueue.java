package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/design-circular-queue/">Design Circular Queue</a>
 */
public class DesignCircularQueue {
    public static class MyCircularQueue {
        private final int maxSize;
        private int currentSize = 0;
        private Node head;
        private Node tail;

        public MyCircularQueue(int k) {
            this.maxSize = k;
        }

        public boolean enQueue(int value) {
            if (currentSize == maxSize) {
                return false;
            }

            if (currentSize == 0) {
                head = new Node(value);
                tail = head;
            } else {
                tail.next = new Node(value);
                tail = tail.next;
            }
            currentSize++;

            return true;
        }

        public boolean deQueue() {
            if (currentSize == 0) {
                return false;
            }

            head = head.next;
            currentSize--;
            return true;
        }

        public int Front() {
            return currentSize > 0 ? head.value : -1;
        }

        public int Rear() {
            return currentSize > 0 ? tail.value : -1;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == maxSize;
        }
    }

    private static class Node {
        final int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
