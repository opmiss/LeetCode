package java;
import java.P025_ReverseNodes.ListNode;

public class P147_InsertionSortList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	public static ListNode insertionSortList(ListNode head){
	    if (head==null) return head; 
		ListNode dummyhead = new ListNode(0); dummyhead.next = head; 
		ListNode cur = head.next; head.next = null; 
		while (cur!=null){
		    ListNode next = cur.next; 
		    insertNode(cur, dummyhead);
		    cur = next; 
		}
		return dummyhead.next; 
	}
	public static void insertNode(ListNode node, ListNode dummyhead){
		ListNode prev = dummyhead; 
		while (prev.next!= null){
			if (node.val < prev.next.val){
			    ListNode next = prev.next; 
			    prev.next = node; 
			    node.next = next; 
				return; 
			}
			prev = prev.next; 
		}
		prev.next = node;
		node.next = null; 
	}

}
