package java;
import problems.linkedlist.*;

public class P002_AddTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry = 0; 
	        ListNode dummy = new ListNode(0); 
	        ListNode node = dummy; 
	        while (l1!=null && l2!=null){
	            int sum = (l1.val+l2.val+carry); 
	            if (sum>9){
	                sum -=10; 
	                carry = 1; 
	            }
	            else carry =0; 
	            node.next = new ListNode(sum);
	            node = node.next; 
	            l1 = l1.next; 
	            l2 = l2.next; 
	        }
	        while (l1!=null){
	            int sum = (l1.val+carry); 
	            if (sum>9){
	                sum -=10; 
	                carry = 1; 
	            }
	            else carry =0; 
	            node.next = new ListNode(sum);
	            node = node.next; 
	            l1 = l1.next; 
	        }
	        while (l2!=null){
	            int sum = (l2.val+carry); 
	            if (sum>9){
	                sum -=10; 
	                carry = 1; 
	            }
	            else carry =0; 
	            node.next = new ListNode(sum);
	            node = node.next; 
	            l2 = l2.next; 
	        }
	        if (carry==1) node.next = new ListNode(1); 
	        return dummy.next; 
	    }

}
