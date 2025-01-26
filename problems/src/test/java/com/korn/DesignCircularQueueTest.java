package com.korn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DesignCircularQueueTest {
    @Test
    void test1() {
        DesignCircularQueue.MyCircularQueue queue = new DesignCircularQueue.MyCircularQueue(3);

        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.enQueue(1)).isTrue();
        assertThat(queue.enQueue(2)).isTrue();
        assertThat(queue.enQueue(3)).isTrue();
        assertThat(queue.enQueue(4)).isFalse();
        assertThat(queue.Rear()).isEqualTo(3);
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.isFull()).isTrue();
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.enQueue(4)).isTrue();
        assertThat(queue.Rear()).isEqualTo(4);
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isFalse();
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.isFull()).isFalse();
    }

    @Test
    void test2() {
        DesignCircularQueue.MyCircularQueue queue = new DesignCircularQueue.MyCircularQueue(7);

        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.enQueue(0)).isTrue();
        assertThat(queue.Front()).isEqualTo(0);
        assertThat(queue.enQueue(4)).isTrue();
        assertThat(queue.Front()).isEqualTo(0);
        assertThat(queue.Rear()).isEqualTo(4);
        assertThat(queue.enQueue(6)).isTrue();
        assertThat(queue.enQueue(3)).isTrue();
        assertThat(queue.Rear()).isEqualTo(3);
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.Front()).isEqualTo(4);
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.Front()).isEqualTo(6);
        assertThat(queue.isEmpty()).isFalse();
        assertThat(queue.isFull()).isFalse();
    }
}