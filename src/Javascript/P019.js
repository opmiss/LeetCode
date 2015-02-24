/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    var dummyhead = new ListNode(0);
    dummyhead.next = head;
    var slow = dummyhead;
    var fast = dummyhead;
    for (var i=0; i<=n; i++){
        if (fast===null) return head;
        fast = fast.next;
    }
    while (fast!==null){
        slow = slow.next;
        fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummyhead.next;
};