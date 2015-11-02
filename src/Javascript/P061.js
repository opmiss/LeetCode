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
var rotateRight = function(head, k) {
	if (head===null||k<1) return head;
	var fast = head;
	for (var n=0; n<k; n++) {
		if (fast===null) break;
		fast = fast.next;
	}
	if (n<k) {
		k = k%n;
		if (k<1) return head;
		fast = head;
		for (n=0; n<k; n++) fast = fast.next;
	}else if (fast===null) return head;
	var slow = head;
	while (fast.next!==null){
		slow = slow.next;
		fast = fast.next;
	}
	var newhead = slow.next;
	slow.next = null;
	fast.next = head;
	return newhead;
};