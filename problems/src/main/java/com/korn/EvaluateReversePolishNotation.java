package com.korn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            "+", Integer::sum,
            "-", (Integer first, Integer second) -> first - second,
            "*", (Integer first, Integer second) -> first * second,
            "/", (Integer first, Integer second) -> first / second
    );

    public int evalRPN(String[] tokens) {
        Deque<Integer> result = new ArrayDeque<>();
        for (String token : tokens) {
            if (OPERATIONS.containsKey(token)) {
                Integer second = result.pollLast();
                Integer first = result.pollLast();
                result.offerLast(OPERATIONS.get(token).apply(first, second));
            } else {
                result.offerLast(Integer.parseInt(token));
            }
        }

        return result.pollLast();
    }
}
