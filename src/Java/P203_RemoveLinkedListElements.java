package Java;

public class P203_RemoveLinkedListElements {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummyhead = new ListNode(0); 
        dummyhead.next = head; 
        ListNode prev = dummyhead; 
        while (prev.next!=null){
            if (prev.next.val==val){
                prev.next = prev.next.next; 
            }
            else prev = prev.next; 
        }
        return dummyhead.next; 
    }
}
