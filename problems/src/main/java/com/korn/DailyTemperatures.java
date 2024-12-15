package com.korn;

import java.util.Stack;

/**
 * Solution for <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 */
public class DailyTemperatures {
    public int[] dailyTemperaturesMovingBackwards(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int hottest = 0;

        for (int currentDayIndex = temperatures.length - 1; currentDayIndex >= 0; currentDayIndex--) {
            int currentTemperature = temperatures[currentDayIndex];
            if (currentTemperature >= hottest) {
                hottest = currentTemperature;
                continue;
            }

            int nextDayIndex = currentDayIndex + 1;
            while (currentTemperature >= temperatures[nextDayIndex]) {
                nextDayIndex = nextDayIndex + result[nextDayIndex];
            }
            result[currentDayIndex] = nextDayIndex - currentDayIndex;
        }

        return result;
    }

    public int[] dailyTemperaturesWithStack(int[] temperatures) {
        Stack<Integer> indices = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int currentDayIndex = 0; currentDayIndex < temperatures.length; currentDayIndex++) {
            while (!indices.isEmpty() && temperatures[currentDayIndex] > temperatures[indices.peek()]) {
                int colderDayIndex = indices.pop();
                result[colderDayIndex] = currentDayIndex - colderDayIndex;
            }
            indices.push(currentDayIndex);
        }

        return result;
    }
}
