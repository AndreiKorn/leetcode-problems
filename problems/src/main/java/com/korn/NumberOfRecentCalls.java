package com.korn;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {
    static class RecentCounter {
        private final Deque<Integer> pings = new ArrayDeque<>();

        public int ping(int t) {
            while (pings.peekFirst() != null && pings.peekFirst() < t - 3000) {
                pings.pollFirst();
            }
            pings.offerLast(t);

            return pings.size();
        }
    }
}
