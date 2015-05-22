package com.leetcode.algorithms;
import com.leetcode.problems.linkedlist.*;
import java.util.*;
public class P138_CopyListwithRandomPointer {
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
	

}
