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
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head==null) return null; 
    	RandomListNode cur=head, next; 
    	while (cur!=null){
    		next = cur.next; 
    		cur.next = new RandomListNode(cur.label); 
    		cur.next.next = next; 
    		cur = next;  
    	}
    	cur = head; 
    	while (cur!=null){
    		if (cur.random!=null) cur.next.random = cur.random.next; 
    		cur = cur.next.next; 
    	}
    	RandomListNode nhead = head.next;
    	cur = head; 
    	while (cur!=null){
    		next = cur.next; 
    		cur.next = (next==null)?null:next.next;
    		next.next = (cur.next==null)?null:cur.next.next; 
    		cur = cur.next; 
    	}
    	return nhead; 
    }
  
    public void test(){
    	RandomListNode head = new RandomListNode(1), cur=head; 
    	cur.next = new RandomListNode(2); cur=cur.next; 
    	cur.next = new RandomListNode(3); cur=cur.next; 
    	cur.next = new RandomListNode(4); cur=cur.next;
    	cur=head; cur.random = cur.next.next; cur=cur.next;
    	cur.random=cur.next.next;
    	RandomListNode chead = copyRandomList(head);
    	cur = chead; 
    	while (cur!=null){
    		System.out.println(cur.label);
    		if (cur.random!=null) System.out.println("->"+cur.random.label); 
    		cur=cur.next; 
    	}
    }
    
    public static void main(String[] args){
    	CopyList cl = new CopyList(); 
    	cl.test(); 
    }
}
