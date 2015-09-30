function ListNode(val){
	this.val = val; 
	this.next = null; 
}

var addTwoNumbers = function(l1, l2) {
    var s = [];
    var carry = 0, sum;
    var dummyhead = new ListNode(0);
    var cur = dummyhead;
    while (l1!==null&&l2!==null){
        sum = l1.val+l2.val+Math.floor(carry);
        cur.next = new ListNode(sum%10);
        carry = sum/10;
        cur = cur.next;
        l1 = l1.next;
        l2 = l2.next;
    }
    while (l1!==null){
        sum = l1.val+Math.floor(carry);
        cur.next = new ListNode(sum%10);
        carry = sum/10;
        cur = cur.next;
        l1 = l1.next;
    }
    while (l2!==null){
        sum = l2.val+Math.floor(carry);
        cur.next = new ListNode(sum%10);
        carry = sum/10;
        cur = cur.next;
        l2 = l2.next;
    }
    return dummyhead.next;
};