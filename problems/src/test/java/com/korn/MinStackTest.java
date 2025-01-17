package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {
    @Test
    void test() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        assertThat(2).isEqualTo(stack.top());
        assertThat(1).isEqualTo(stack.getMin());
        stack.pop();
        assertThat(1).isEqualTo(stack.top());
        assertThat(1).isEqualTo(stack.getMin());
        stack.push(-1);
        assertThat(-1).isEqualTo(stack.top());
        assertThat(-1).isEqualTo(stack.getMin());
        stack.push(-1);
        stack.push(-1);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        assertThat(2).isEqualTo(stack.top());
        assertThat(-1).isEqualTo(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(2).isEqualTo(stack.top());
        assertThat(-1).isEqualTo(stack.getMin());
        stack.pop();
        assertThat(-1).isEqualTo(stack.top());
        assertThat(-1).isEqualTo(stack.getMin());
    }
}