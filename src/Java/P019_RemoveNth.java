package Java;


public class P019_RemoveNth {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode dummyhead = new ListNode(0); 
	        dummyhead.next = head; 
	        ListNode end = head; 
	        for (int i=0; i<n; i++) end = end.next; 
	        ListNode prev = dummyhead; 
	        ListNode cur = head; 
	        while (end !=null){
	            end = end.next; 
	            prev = cur; 
	            cur = cur.next; 
	        }
	        prev.next = cur.next; 
	        cur= null;
	        return dummyhead.next; 
	    }

}
