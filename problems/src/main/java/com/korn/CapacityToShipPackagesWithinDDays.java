package com.korn;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Capacity To Ship Packages Within D Days</a>
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int minimum = 0;
        int maximum = 0;
        for (int weight : weights) {
            minimum = Math.max(minimum, weight);
            maximum += weight;
        }

        while (minimum < maximum) {
            int middle = minimum + (maximum - minimum) / 2;
            if (canShip(weights, middle, days)) {
                maximum = middle;
            } else {
                minimum = middle + 1;
            }
        }

        return minimum;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int daysRequired = 1;
        int leftCapacity = capacity;
        for (int weight : weights) {
            if (weight <= leftCapacity) {
                leftCapacity -= weight;
            } else {
                daysRequired++;
                leftCapacity = capacity - weight;
            }
        }
        return daysRequired <= days;
    }
}
