package Java;
/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class P138_CopyListwithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null; 
        RandomListNode cur=head, next; 
    	while (cur!=null){
    		next = cur.next; 
    		cur.next = new RandomListNode(cur.label); 
    		cur.next.next = next; 
    		cur = next;  
    	}
    	cur = head; 
    	while (cur!=null){
    		if (cur.random!=null) cur.next.random = cur.random.next; 
    		cur = cur.next.next; 
    	}
    	RandomListNode nhead = head.next;
    	cur = head; 
    	while (cur!=null){
    		next = cur.next; 
    		cur.next = (next==null)?null:next.next;
    		next.next = (cur.next==null)?null:cur.next.next; 
    		cur = cur.next; 
    	}
    	return nhead; 
    }
}
