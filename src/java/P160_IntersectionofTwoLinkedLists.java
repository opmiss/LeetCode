package java;

public class P160_IntersectionofTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
		}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA; 
        ListNode b = headB; 
        while (a!=null && b!=null){
            a = a.next; 
            b = b.next; 
        }
        int fa=0, fb=0;
        while (a!=null){
            a=a.next; 
            fa++; 
        }
        while (b!=null){
            b=b.next; 
            fb++; 
        }
        a = headA; 
        b = headB; 
        while (fa>0){
            a=a.next; 
            fa--; 
        }
        while (fb>0){
            b=b.next;
            fb--; 
        }
        while (a!=null&&b!=null){
            if (a==b) return a;
            a=a.next; 
            b=b.next; 
        }
        return null; 
    }

}
