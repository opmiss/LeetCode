package java;

import problems.linkedlist.ListNode;

public class P141_LinkedListCycle {
	public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode slow=head, fast = head; 
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next; 
            fast = fast.next; fast = fast.next; 
            if (slow == fast) {
                slow = head; 
                while(slow!=fast){
                    slow = slow.next; 
                    fast = fast.next; 
                }
                return slow; 
            }
        }
        return null; 
    }

}
