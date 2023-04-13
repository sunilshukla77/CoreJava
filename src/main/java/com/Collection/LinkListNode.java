package com.Collection;

public class LinkListNode {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(start, slow);
        node.right = sortedListToBST(slow.next, end);

        return node;
    }

}
/*
Converting a LinkedList to a TreeNode involves constructing a binary tree where each node in the tree represents a node in the linked list.
 Here is an example of how you can convert a singly linked list into a binary tree:

 In this example, the sortedListToBST() method takes a ListNode representing the head of the linked list to be converted
 into a binary search tree (BST). The TreeNode class represents each node in the binary tree.

The method recursively constructs the binary tree by dividing the linked list in half at each step, and creating a new
TreeNode object for the middle node in the linked list segment. The left subtree is constructed recursively using the
first half of the linked list, while the right subtree is constructed recursively using the second half of the linked list.

At each step, the method takes two arguments: start and end, which represent the start and end nodes of the current
 segment of the linked list being processed. Initially, start is the head of the linked list and end is null.

The base case for the recursive function is when start equals end, which means that the current linked list segment is empty.

The method uses a slow pointer and a fast pointer to find the middle node of the linked list segment. The slow pointer
moves one node at a time while the fast pointer moves two nodes at a time. When the fast pointer reaches the end of the
current segment or the node before the end, the slow pointer is at the middle node.

The method then creates a new TreeNode object for the middle node and recursively constructs the left and right subtrees
using the first half and second half of the linked list, respectively.

Finally, the method returns the root node of the binary tree.

Note that this implementation assumes that the linked list is already sorted in ascending order. If the linked list is not
sorted, you will need to first sort it before converting it to a binary search tree.

 */
