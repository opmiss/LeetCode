package com.leetcode.algorithms;
import com.leetcode.problems.linkedlist.ListNode;

public class P143_ReorderList {
	public static void reorderList(ListNode head) {
		 if (head == null || head.next==null) return; 
		 ListNode middle = half(head); 
		 ListNode list = reverse(middle); 
		 interleave(head, list); 
	 }
	 
	 public static ListNode half(ListNode head){
		 ListNode slow = head, fast=head; 
		 while(fast.next!=null && fast.next.next!=null){
			 slow = slow.next; fast = fast.next; fast = fast.next; 
		 }
		 if (fast.next==null) return slow; 
		 else return slow.next; 
	 }
	 
	 public static ListNode reverse(ListNode head){
		 if (head == null || head.next==null) return head; 
		 ListNode dummyhead = new ListNode(0); 
		 dummyhead.next = head; 
		 ListNode nexthead = head.next;
		 head.next = null;  
		 while(null!=nexthead){ 
			 dummyhead.next = nexthead; 
			 ListNode N = nexthead.next; 
			 nexthead.next = head; 
			 head = nexthead; 
			 nexthead = N; 
		 }
		 return dummyhead.next; 
	 }
	 public static void interleave(ListNode head, ListNode list){
		 ListNode n1 = head; 
		 ListNode n2 = list; 
		 while(null!=n2){
			 ListNode nn1 = n1.next; 
			 ListNode nn2 = n2.next; 
			 n1.next = n2; 
			 if (n2.next!=null){
				 n2.next = nn1; 
			 }
			 else break; 
			 n1 = nn1; 
			 n2 = nn2; 
		 }
	 }

}
