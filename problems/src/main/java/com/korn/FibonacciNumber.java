package com.korn;

public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else if (n == 2) {
            return 1;
        }

        int beforePrevious = 1;
        int previous = 1;
        for (int i = 3; i < n; i++) {
            int next = beforePrevious + previous;
            beforePrevious = previous;
            previous = next;
        }

        return beforePrevious + previous;
    }
}
