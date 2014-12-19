package com.leetcode.problems.linkedlist;

/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */

public class CopyList {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
    public RandomListNode copyRandomList(RandomListNode head) {
        return null; 
    }
}
