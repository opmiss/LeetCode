package java;
import problems.linkedlist.*;

public class P024_SwapNodes {
	 public ListNode swapPairs(ListNode head) {
	        if (head == null) return head;
	        ListNode dummyhead = new ListNode(0);
	        dummyhead.next = head; 
	        ListNode prev = dummyhead; 
	        ListNode cur = head; 
	        ListNode next = head.next; 
	        while (next!=null){
	            prev.next = next; 
	            cur.next = next.next; 
	            next.next = cur;
	            prev = cur; 
	            cur = prev.next; 
	            if (cur!=null) next = cur.next; 
	            else break; 
	        }
	        return dummyhead.next; 
	    }

}
