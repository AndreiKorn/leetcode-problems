package com.korn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Solution for
 * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">Maximum Profit in Job Scheduling</a>
 */
public class MaximumProfitInJobScheduling {
    private final int[] memo = new int[50001];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(Job::startTime));

        return getMaxProfit(jobs, 0);
    }

    private int getMaxProfit(List<Job> jobs, int position) {
        if (position >= jobs.size()) {
            return 0;
        }

        if (memo[position] > 0) {
            return memo[position];
        }

        int nextIndex = findNextJob(jobs, jobs.get(position).endTime());

        int maxProfit = Math.max(
                getMaxProfit(jobs, position + 1),
                jobs.get(position).profit() + getMaxProfit(jobs, nextIndex)
        );

        memo[position] = maxProfit;
        return maxProfit;
    }

    private int findNextJob(List<Job> jobs, int endTime) {
        int start = 0;
        int end = jobs.size() - 1;
        int nextIndex = jobs.size();

        while (start <= end) {
            int middle = end + (start - end) / 2;
            if (jobs.get(middle).startTime() >= endTime) {
                nextIndex = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return nextIndex;
    }

    record Job(
            int startTime,
            int endTime,
            int profit
    ) {
    }
}
