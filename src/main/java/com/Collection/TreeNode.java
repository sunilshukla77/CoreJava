package com.Collection;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private Object data;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(Object data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public Object getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void addChild(TreeNode child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(TreeNode child) {
        children.remove(child);
        child.setParent(null);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}

