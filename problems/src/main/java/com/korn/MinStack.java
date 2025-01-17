package com.korn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */
public class MinStack {
    private final Deque<Value> stack = new ArrayDeque<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.addLast(new Value(val, val));
        } else {
            Value top = stack.getLast();
            stack.addLast(new Value(val, Math.min(val, top.minValue())));
        }
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().elementValue();
    }

    public int getMin() {
        return stack.getLast().minValue();
    }

    private record Value(int elementValue, int minValue) {
    }
}
