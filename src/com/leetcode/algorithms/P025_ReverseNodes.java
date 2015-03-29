package com.leetcode.algorithms;
import com.leetcode.problems.linkedlist.*;

public class P025_ReverseNodes {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k<=1 || head==null) return head; 
		ListNode dummyhead = new ListNode(0);
		dummyhead.next = head; 
		ListNode start = dummyhead; 
		ListNode end = head; 
		ListNode cur = head.next;
		
		ListNode nextStart, nextCur; 
	
		while (head!=null){
			for (int i=0; i<k; i++) {
				end = end.next;
				if (end==null && i<k-1) return dummyhead.next; 
			}
			while (cur!=end){
				nextCur = cur.next; 
				nextStart = start.next; 
				start.next = cur; 
				cur.next = nextStart; 
				head.next = nextCur; 
				cur = nextCur; 
			}
			start = head; 
			head = end; 
		}
		return dummyhead.next; 
  }

}
