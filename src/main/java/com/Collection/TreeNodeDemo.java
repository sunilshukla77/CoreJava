package com.Collection;

public class TreeNodeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("Root");
        TreeNode child1 = new TreeNode("Child 1");
        TreeNode child2 = new TreeNode("Child 2");
        TreeNode grandchild1 = new TreeNode("Grandchild 1");
        TreeNode grandchild2 = new TreeNode("Grandchild 2");

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);

    }
}

/*
In this implementation, a TreeNode object is created with an Object data parameter in its constructor.
This can be any type of data that the tree needs to store.

The TreeNode class also has a reference to its parent node (parent) and a list of child nodes (children).
 The addChild() and removeChild() methods allow nodes to be added or removed from the list of child nodes.

The isLeaf() method returns true if the node has no children.

With this TreeNode class, we can create a tree data structure by creating a root node and adding child nodes to it,
and then adding child nodes to those child nodes, and so on.
 */
