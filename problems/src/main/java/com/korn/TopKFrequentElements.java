package com.korn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution for <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[heap.size()];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll().getKey();
        }
        return result;
    }
}
