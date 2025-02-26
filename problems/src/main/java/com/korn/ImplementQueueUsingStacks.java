package com.korn;

import java.util.Stack;

/**
 * Solution for <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 */
public class ImplementQueueUsingStacks {
    class MyQueue {
        private final Stack<Integer> main = new Stack<>();
        private final Stack<Integer> additional = new Stack<>();
        private Integer front;

        public void push(int x) {
            if (main.isEmpty()) {
                front = x;
            }
            main.push(x);
        }

        public int pop() {
            if (additional.isEmpty()) {
                while (!main.isEmpty()) {
                    additional.push(main.pop());
                }
            }
            return additional.pop();
        }

        public int peek() {
            return additional.isEmpty() ? front : additional.peek();
        }

        public boolean empty() {
            return main.isEmpty() && additional.isEmpty();
        }
    }
}
