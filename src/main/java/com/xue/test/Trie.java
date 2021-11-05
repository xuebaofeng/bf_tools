package com.xue.test;

import java.util.HashMap;

public class Trie {
	class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isWord;
	}

	TrieNode root = new TrieNode();

	public void insert(String word){
		TrieNode current = root;
		for(char l: word.toCharArray()){
			current = current.children.computeIfAbsent(l, c -> new TrieNode());
		}
		current.isWord = (true);
	}


	public boolean find(String word){
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				return false;
			}
			current = node;
		}
		return current.isWord;
	}

	public static void main(String[] args){
		Trie t = new Trie();
		t.insert("abc");
		t.insert("bcd");
		System.out.println(t.find("abc"));
		System.out.println(t.find("ab"));
		System.out.println(t.find("bc"));
	}
}
