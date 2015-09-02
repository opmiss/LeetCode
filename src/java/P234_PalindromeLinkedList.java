package java;
import problems.linkedlist.*;

public class P234_PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head==null) return true; 
        ListNode fast = head; 
        ListNode slow = head; 
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next; 
            slow = slow.next; 
        }
        ListNode right = slow.next; 
        slow.next = reverse(right);
        right = slow.next; 
        slow = head; 
        while (right!=null){
            if (slow.val!=right.val) return false; 
            slow = slow.next; 
            right = right.next; 
        }
        return true; 
    }
    public ListNode reverse(ListNode head){
        if (head==null) return null; 
        ListNode cur = head, next = cur.next, nextnext; 
        cur.next = null;
        while (next!=null){
            nextnext = next.next; 
            next.next = cur; 
            cur = next; 
            next = nextnext; 
        }
        return cur; 
    }
}
