package com.korn;

public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int beforePrevious = 0;
        int previous = 1;
        for (int i = 2; i < n; i++) {
            int next = beforePrevious + previous;
            beforePrevious = previous;
            previous = next;
        }

        return beforePrevious + previous;
    }
}
