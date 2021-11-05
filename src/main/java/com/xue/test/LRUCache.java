package com.xue.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	int capacity;
	Node head;
	Node tail;
	Map<Integer, Node> map;
	int size;

	public LRUCache(int capacity){
		this.capacity = capacity;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.pre = head;
		map = new HashMap();
	}

	public int get(int key){
		Node node = map.get(key);
		if(node == null) return -1;
		remove(node);
		top(node);
		return node.val;
	}

	public void put(int key, int value){
		Node node = map.get(key);
		if(node == null){
			node = new Node(key, value);
			if(size == capacity){
				map.remove(tail.pre.key);
				remove(tail.pre);
			}
			map.put(key, node);
		}else{
			node.val = value;
			remove(node);
		}
		top(node);
	}

	void top(Node node){
		node.next = head.next;
		head.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	void remove(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public static void main(String[] args){
		/*["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]*/
		LRUCache obj = new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		obj.get(1);
		obj.put(3, 3);
		obj.get(2);
		obj.put(4, 4);
		obj.get(1);
		obj.get(3);
		obj.get(4);
	}
}

class Node {
	int key;
	int val;
	Node next;
	Node pre;

	Node(int key, int val){
		this.key = key;
		this.val = val;
	}

	Node(){
	}
}

