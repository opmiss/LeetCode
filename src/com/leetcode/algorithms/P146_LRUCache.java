package com.leetcode.algorithms;
import java.util.*; 

public class P146_LRUCache {
	 class Node {
	    	int key; 
			int val;
			Node prev; 
			Node next; 
			Node(){
			}
			Node(int k, int v) {
				key = k; 
				val = v;
			}
			Node(Node n){ 
				val = n.val; 
			}
		}
		int limit = 0; 
		int listsize =0; 
		Node dummyhead = new Node(); 
		Node dummytail = new Node(); 
		HashMap<Integer, Node> map = new HashMap<Integer, Node>(); 
	    
	    public P146_LRUCache(int capacity) {
	    	listsize =0; 
	        limit = capacity; 
	        map = new HashMap<Integer, Node>(); 
	        dummyhead.next = dummytail; 
	        dummyhead.prev = null; 
	        dummytail.next = null; 
	        dummytail.prev = dummyhead; 
	    }
	    
	    public int get(int key) {
	    	Node N = map.get(key); 
	      	if (N==null) return -1; 
			N.prev.next = N.next; 
			N.next.prev = N.prev;
			
			N.next = dummyhead.next; 
			N.prev = dummyhead; 
			dummyhead.next.prev = N; 
			dummyhead.next = N; 
			return N.val;   
	    }
	    
	    public void set(int key, int value) {
	    	Node N = map.get(key); 
	    	if (null!=N){
	    		N.prev.next = N.next; 
	    		N.next.prev = N.prev;
	    		N.val = value; 
	    	}
	    	else{
	    		N = new Node(key, value); 
	    		map.put(key, N); 
	    		listsize++; 
	    	}
	    	N.next = dummyhead.next; 
			N.prev = dummyhead; 
			dummyhead.next.prev = N; 
			dummyhead.next = N; 
			if (listsize >limit) { 
				Node D = dummytail.prev;
				dummytail.prev = D.prev; 
				D.prev.next = dummytail; 
				map.remove(D.key); 
				listsize--; 
			}
	    }

}
