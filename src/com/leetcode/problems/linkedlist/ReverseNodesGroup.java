package com.leetcode.problems.linkedlist;
/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example, 
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */

public class ReverseNodesGroup {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
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
