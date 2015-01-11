/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
	if (k<2) return head;
	if (head===null || head.next===null) return head;
	var dummy = new ListNode(0);
	dummy.next = head;
	var prev = dummy, start=head, next=head;
	while (next!==null){
		for (var i=0; i<k; i++){
			if (next===null) return dummy.next;
			next = next.next;
		}
		var nextstart = start.next;
		start.next = next;
		var end = start;
		while (nextstart!==next){
			prev.next = nextstart;
			var t = nextstart.next;
			nextstart.next = start;
			start = nextstart;
			nextstart = t;
		}
		prev = end;
		start = next;
	}
	return dummy.next;
};