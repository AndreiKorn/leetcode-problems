package com.korn.model;

import java.util.List;

public class NaryNode {
    public final int val;
    public final List<NaryNode> children;

    public NaryNode(int val) {
        this.val = val;
        this.children = List.of();
    }

    public NaryNode(int val, List<NaryNode> children) {
        this.val = val;
        this.children = children;
    }
}
