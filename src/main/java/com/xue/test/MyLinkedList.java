package com.xue.test;

public class MyLinkedList {

	class Node {
		int val;
		Node pre;
		Node next;

		Node(){

		}

		Node(int v){
			val = v;
		}
	}

	Node head;
	Node tail;
	int size;

	/*Initialize your data structure here. */
	public MyLinkedList(){
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.pre = head;
	}

	/*Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index){
		if(index < 0 || index > size) return -1;

		return getNode(index).val;
	}

	Node getNode(int index){
		Node cur = head;
		for(int i = 0; i < index; i++){
			cur = cur.next;
		}
		return cur;
	}

	/*Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val){
		addAtIndex(0, val);
	}

	/*Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val){
		addAtIndex(size, val);
	}

	/*Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	// node->newNode
	public void addAtIndex(int index, int val){
		if(index < 0 || index > size) return;
		Node node = getNode(index);
		Node newNode = new Node(val);
		newNode.next = node.next;
		newNode.next.pre = newNode;
		node.next = newNode;
		newNode.pre = node;
		size++;
	}


	/*Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index){
		if(index < 0 || index > size) return;
		Node node = getNode(index);
		Node pre = node.pre;
		node.next.pre = pre;
		pre.next = node.next;
		size--;
	}

	/*
	* ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
	* */
	public static void main(String[] args){
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(1);
		obj.addAtTail(3);
		obj.addAtIndex(1, 2);
		obj.get(1);
		obj.deleteAtIndex(1);
		obj.get(1);
	}
}
