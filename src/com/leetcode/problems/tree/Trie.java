package com.leetcode.problems.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	class TrieNode{
	    String value = null; 
	    Map<Character, TrieNode> child = new HashMap<Character, TrieNode>();
		public TrieNode(){
			
		}
	}
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root; 
        for (int i=0; i<word.length(); i++){
            TrieNode node = cur.child.get(word.charAt(i)); 
            if (node==null) {
                node = new TrieNode(); 
                cur.child.put(word.charAt(i), node); 
            }
            cur = node; 
        }
        cur.value = word; 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root; 
        for (int i=0; i<word.length(); i++){
            TrieNode node = cur.child.get(word.charAt(i)); 
            if (node==null) return false; 
            cur = node; 
        }
        return word.equals(cur.value); 
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root; 
        for (int i=0; i<prefix.length(); i++){
            TrieNode node = cur.child.get(prefix.charAt(i)); 
            if (node==null) return false; 
            cur = node; 
        }
        return true; 
    }
    
    public void test(){
    	Trie trie = new Trie(); 
    	trie.insert("hello");
    	trie.insert("hi");
    	System.out.println(trie.search("hi"));
    	System.out.println(trie.search("he")); 
    	System.out.println(trie.startsWith("he"));
    }
    
    public static void main(String[] args){
    	Trie t = new Trie(); 
    	t.test(); 
    }
}
