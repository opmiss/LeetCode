package com.leetcode.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */

public class CopyList {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	Map<RandomListNode, RandomListNode> map; 
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	map = new HashMap<RandomListNode, RandomListNode>(); 
    	RandomListNode chead = null; 
    	chead=copy(head, chead); 
        return chead; 
    }
    public RandomListNode copy(RandomListNode from, RandomListNode to){
    	if (from==null) return null; 
    	RandomListNode node = map.get(from);
    	if (node==null) {
    		if (to==null) to = new RandomListNode(from.label); 
    		map.put(from, to); 
    	}
    	else {
    		to = node; 
    		return to; 
    	}
    	to.next = copy(from.next, to.next);
    	to.random = copy(from.random, to.random); 
    	return to; 
    }
    public void test(){
    	RandomListNode head = new RandomListNode(-1); 
    	RandomListNode chead = copyRandomList(head);
    	System.out.println(chead.label); 
    }
    
    public static void main(String[] args){
    	CopyList cl = new CopyList(); 
    	cl.test(); 
    }
}
