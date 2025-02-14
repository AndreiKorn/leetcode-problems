package com.korn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution for <a href="https://leetcode.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> byStart = (int[] first, int[] second) -> first[0] != second[0]
                ? Integer.compare(first[0], second[0])
                : Integer.compare(first[1], second[1]);
        PriorityQueue<int[]> sortedIntervals = new PriorityQueue<>(byStart);
        for (int[] interval : intervals) {
            sortedIntervals.offer(interval);
        }

        Comparator<int[]> byEnd = (int[] first, int[] second) -> first[1] != second[1]
                ? Integer.compare(first[1], second[1])
                : Integer.compare(first[0], second[0]);
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(byEnd);
        int minRooms = 0;
        int[] interval;
        while ((interval = sortedIntervals.poll()) != null) {
            while (!busyRooms.isEmpty() && busyRooms.peek()[1] <= interval[0]) {
                busyRooms.poll();
            }
            busyRooms.offer(interval);
            minRooms = Math.max(minRooms, busyRooms.size());
        }
        return minRooms;
    }
}
