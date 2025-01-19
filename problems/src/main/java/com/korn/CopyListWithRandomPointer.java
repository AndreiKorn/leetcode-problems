package com.korn;

import java.util.HashMap;
import java.util.Map;

import com.korn.model.NodeWithRandom;

/**
 * Solution for <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Copy List with Random Pointer</a>
 */
public class CopyListWithRandomPointer {
    public NodeWithRandom copyRandomList(NodeWithRandom head) {
        Map<NodeWithRandom, NodeWithRandom> visitedNodes = new HashMap<>();
        NodeWithRandom dummy = new NodeWithRandom(-1);
        NodeWithRandom current = head;
        NodeWithRandom newNode = dummy;
        while (current != null) {
            newNode.next = visitedNodes.containsKey(current)
                    ? visitedNodes.get(current)
                    : new NodeWithRandom(current.val);
            newNode = newNode.next;
            visitedNodes.put(current, newNode);

            if (current.random != null && !visitedNodes.containsKey(current.random)) {
                NodeWithRandom newRandomNode = new NodeWithRandom(current.random.val);
                visitedNodes.put(current.random, newRandomNode);
            }
            newNode.random = visitedNodes.get(current.random);
            current = current.next;
        }

        return dummy.next;
    }
}
