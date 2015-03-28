package com.leetcode.algorithms;
import java.util.*;
import com.leetcode.problems.linkedlist.*;

public class P023_MergeKLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists==null) return null; 
        if (lists.size()==1) return lists.get(0); 
        ListNode start = null; 
        for (ListNode node:lists){
            start = mergeTwoLists(start, node); 
        }
        return start; 
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0); 
        ListNode prev = dummyhead; 
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){ 
                prev.next = l1;
                l1 = l1.next; 
            }
            else {
                prev.next = l2; 
                l2 = l2.next; 
            }
            prev = prev.next; 
        }
        if (l1==null) prev.next = l2; 
        else prev.next = l1; 
        return dummyhead.next; 
    }

}
