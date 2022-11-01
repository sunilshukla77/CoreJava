package com.thread.threadPool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache {
	/**
	 * Algorithm :
	 * 
	 * 1. Everytime when we add the node check if it exists .
	 *  1.1 if exists then update the value .
	 *  1.2 move this node to head. 
	 *  1.3 if the capaicity reaches then remove node from tail . 
	 *  1.4 move the current node to head.
	 * 
	 * 2. Everytime when we get 
	 * 2.1 then we need to move this node to head.
	 * 
	 * 3. Remove the node from tail thats it.
	 * 
	 * }
	 **/

	private int capacity;
	private AtomicInteger curSize = new AtomicInteger();
	private ConcurrentHashMap<Integer, Node> map = new ConcurrentHashMap<>();
	private Node head = new Node();
	private Node tail = new Node();
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

public LRUCache(int capacity) {
   this.capacity = capacity;
   head.next = tail;
   tail.prev = head;
}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node node = map.get(key);
		// move this current Node to front
		moveToHead(node);
		return node.val;

	}

	public void put(int key, int value) {
		// The key is already present
		Node curNode = map.get(key);
		if (curNode != null) {
			// if value exist update
			curNode.val = value;
			// moveTo head , so now its used recently
			moveToHead(curNode);
			return;
		}
		Node newNode = new Node(value, key);
		map.put(key, newNode);
		addToHead(newNode);
		if (curSize.incrementAndGet() > capacity) {
			Node nodeToRemove = tail.prev;
			removeNode(nodeToRemove);
			map.remove(nodeToRemove.key);
			curSize.decrementAndGet();
		}
	}

	private void moveToHead(Node node) {
		// remove
		removeNode(node);
		addToHead(node);

	}

	private void removeNode(Node node) {
		try {
			readWriteLock.writeLock().lock();
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	private void addToHead(Node node) {
		try {
			readWriteLock.writeLock().lock();
			node.next = head.next;
			node.prev = head;
			head.next.prev = node;
			head.next = node;
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
}

class Node {
	Integer val;
	Integer key;
	Node next;
	Node prev;

	public Node(int val, int key) {
		this.val = val;
		this.key = key;
	}

	public Node() {

	}
}

/**
 * Your LRUCache object will be instantiated and called as such: 
 * LRUCache obj = new LRUCache(capacity); 
 * int param_1 = obj.get(key); 
 * obj.put(key,value);
 */
