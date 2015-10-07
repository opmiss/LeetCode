package java;

public class P206_ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = head;
		ListNode next = head.next;
		cur.next = null;
		while (next != null) {
			ListNode nextnext = next.next;
			next.next = cur;
			cur = next;
			next = nextnext;
		}
		return cur;
	}

}
