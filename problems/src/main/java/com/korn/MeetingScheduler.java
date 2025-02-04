package com.korn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/meeting-scheduler">Meeting Scheduler</a>
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(slots -> slots[0]));
        Arrays.sort(slots2, Comparator.comparingInt(slots -> slots[0]));

        int index1 = 0;
        int index2 = 0;
        while (index1 < slots1.length && index2 < slots2.length) {
            int[] slot1 = slots1[index1];
            int[] slot2 = slots2[index2];
            int[] mergeResult = new int[]{Math.max(slot1[0], slot2[0]), Math.min(slot1[1], slot2[1])};
            if (mergeResult[1] - mergeResult[0] >= duration) {
                return List.of(mergeResult[0], mergeResult[0] + duration);
            }

            if (slot1[1] < slot2[1]) {
                index1++;
            } else {
                index2++;
            }
        }

        return List.of();
    }
}
