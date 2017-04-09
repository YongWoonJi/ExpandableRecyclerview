package com.example.jyw.expandablerecyclerview.model;

import java.util.List;

/**
 * Created by JYW on 2017-04-09 009.
 */

public class Node {

    private Node parent;

    public List<Node> children;

    private boolean isExpand;


    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getLevel() {
        return isRoot() ? 0 : parent.getLevel() + 1;
    }

    public boolean isRoot() {
        return parent == null;
    }


}
