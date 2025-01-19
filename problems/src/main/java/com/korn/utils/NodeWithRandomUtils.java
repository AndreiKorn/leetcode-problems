package com.korn.utils;

import com.korn.model.NodeWithRandom;

public class NodeWithRandomUtils {
    private NodeWithRandomUtils() {
    }

    public static NodeWithRandom createList(Integer[]... values) {
        NodeWithRandom[] nodes = new NodeWithRandom[values.length];
        for (int i = 0; i < values.length; i++) {
            if (nodes[i] == null) {
                nodes[i] = new NodeWithRandom(values[i][0]);
                if (i > 0) {
                    nodes[i - 1].next = nodes[i];
                }
            }

            Integer randomIndex = values[i][1];
            if (randomIndex != null) {
                if (nodes[randomIndex] == null) {
                    nodes[randomIndex] = new NodeWithRandom(values[randomIndex][0]);
                }
                nodes[i].random = nodes[randomIndex];
            }
        }
        return nodes.length > 0 ? nodes[0] : null;
    }
}
