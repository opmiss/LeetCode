package java;

public class P148_SortList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;  
        ListNode middle = getMiddle(head); 
        ListNode half = middle.next; middle.next = null; 
        return merge(sortList(head), sortList(half)); 
    }
    
    public ListNode merge(ListNode A, ListNode B){
        ListNode dummyhead= new ListNode(0); 
        ListNode h = dummyhead, a = A, b = B; 
        while (a!=null && b!=null){
            if (a.val<b.val){
                h.next = a; a = a.next;  
            } 
            else {
                h.next = b; b = b.next;
            }
            h = h.next; 
        }
        h.next = (a==null)? b:a; 
        return dummyhead.next; 
    }
    
    public ListNode getMiddle(ListNode head){
        ListNode slow=head, fast=head;  
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next; fast = fast.next.next;  
        }
        return slow; 
    }

}
