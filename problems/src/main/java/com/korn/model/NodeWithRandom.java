package com.korn.model;

public class NodeWithRandom {
    public int val;
    public NodeWithRandom next;
    public NodeWithRandom random;

    public NodeWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
