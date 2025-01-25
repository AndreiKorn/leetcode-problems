package com.korn;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-vacation-days/">Maximum Vacation Days</a>
 */
public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int numberOfCities = flights.length;
        for (int day = days[0].length - 2; day >= 0; day--) {
            int nextDay = day + 1;
            for (int cityFromIndex = 0; cityFromIndex < numberOfCities; cityFromIndex++) {
                int maxDays = 0;
                for (int cityToIndex = 0; cityToIndex < numberOfCities; cityToIndex++) {
                    if (cityFromIndex == cityToIndex || flights[cityFromIndex][cityToIndex] == 1) {
                        maxDays = Math.max(maxDays, days[cityToIndex][nextDay]);
                    }
                }
                days[cityFromIndex][day] += maxDays;
            }
        }

        int result = days[0][0];
        for (int i = 1; i < flights[0].length; i++) {
            if (flights[0][i] == 1) {
                result = Math.max(result, days[i][0]);
            }
        }
        return result;
    }
}
