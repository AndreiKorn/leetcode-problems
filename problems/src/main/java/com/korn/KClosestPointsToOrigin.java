package com.korn;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] first, int[] second) ->
                (second[0] * second[0] + second[1] * second[1]) - (first[0] * first[0] + first[1] * first[1])
        );

        for (int[] current : points) {
            heap.add(current);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[heap.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
