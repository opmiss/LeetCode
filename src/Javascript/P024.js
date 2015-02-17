/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
	if (head===null||head.next===null) return head;
	var dummy = new ListNode(0);
	dummy.next = head;
	var prev = dummy, cur = head, next = head.next;
	while (next!==null){
			//exchange cur and next;
		prev.next = next;
		cur.next = next.next;
		next.next = cur;
		prev = cur;
		cur = cur.next;
		if (cur===null) break;
		next = cur.next;
	}
	return dummy.next;
};