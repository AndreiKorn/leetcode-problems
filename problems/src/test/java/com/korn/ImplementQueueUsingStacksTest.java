package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImplementQueueUsingStacksTest {
    @Test
    void test1() {
        ImplementQueueUsingStacks.MyQueue queue = new ImplementQueueUsingStacks().new MyQueue();
        queue.push(1);
        queue.push(2);
        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.empty()).isFalse();
        assertThat(queue.peek()).isEqualTo(2);
        assertThat(queue.pop()).isEqualTo(2);
        assertThat(queue.empty()).isTrue();
    }

    @Test
    void test2() {
        ImplementQueueUsingStacks.MyQueue queue = new ImplementQueueUsingStacks().new MyQueue();
        queue.push(1);
        queue.push(2);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.empty()).isFalse();
        assertThat(queue.peek()).isEqualTo(2);
        assertThat(queue.empty()).isFalse();
    }

    @Test
    void test3() {
        ImplementQueueUsingStacks.MyQueue queue = new ImplementQueueUsingStacks().new MyQueue();
        queue.push(1);
        queue.push(2);
        assertThat(queue.pop()).isEqualTo(1);
        queue.push(3);
        queue.push(4);
        assertThat(queue.pop()).isEqualTo(2);
        assertThat(queue.peek()).isEqualTo(3);
        assertThat(queue.pop()).isEqualTo(3);
        assertThat(queue.pop()).isEqualTo(4);
        assertThat(queue.empty()).isTrue();
    }
}