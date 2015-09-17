package Java;

public class P021_MergeLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode dummyhead = new ListNode(0); 
	        ListNode prev = dummyhead; 
	        while (l1!=null && l2!=null){
	            if (l1.val < l2.val){ 
	                prev.next = l1;
	                l1 = l1.next; 
	            }
	            else {
	                prev.next = l2; 
	                l2 = l2.next; 
	            }
	            prev = prev.next; 
	        }
	        if (l1==null) prev.next = l2; 
	        else prev.next = l1; 
	        return dummyhead.next; 
	    }

}
