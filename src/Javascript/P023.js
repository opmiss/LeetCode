/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
	return lists.reduce(
											function(l1, l2){
											var dummy = new ListNode(0);
											var prev = dummy;
											while (l1!==null && l2!==null){
											if (l1.val<l2.val){
											prev.next = l1;
											l1 = l1.next;
											}else{
											prev.next = l2;
											l2 = l2.next;
											}
											prev = prev.next;
											}
											if (l1===null) prev.next = l2;
											else prev.next = l1;
											return dummy.next;
											}, null);
};