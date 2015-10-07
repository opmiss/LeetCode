package java;

import java.util.*;

public class P208_ImplementTrie {
	class TrieNode {
	    // Initialize your data structure here.
	    String value = null; 
	    Map<Character, TrieNode> child = new HashMap<Character, TrieNode>(); 
	    public TrieNode() {
	    }
	}

	public class Trie {
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
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
	
	public static void main(String[] args){
		String value = null; 
		String word = ""; 
		System.out.println(word.equals(value)); 
	}

}
