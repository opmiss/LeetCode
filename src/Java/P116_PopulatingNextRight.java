package Java;


public class P116_PopulatingNextRight {
	/*
	 * Given a binary tree
	 * Populate each next pointer to point to its next right node. 
	 * If there is no next right node, the next pointer should be set to NULL.
	 * Initially, all next pointers are set to NULL.
	 * Note:
	 * You may only use constant extra space.
	 * The given tree could be any binary tree.
	 * For example,
	 * Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	   After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
	 */
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		TreeLinkNode cur=root, prev=null, next=null;
		while (cur!=null){
			do {
				if (cur.left!=null){
					if (prev==null) prev=cur.left; 
					else {
						prev.next=cur.left; 
						prev = prev.next; 
					}
					if (next==null) next = cur.left; 
				}
				if (cur.right!=null){
					if (prev==null) prev=cur.right; 
					else {
						prev.next = cur.right; 
						prev = prev.next; 
					}
					if (next==null) next = cur.right; 
				}
				cur = cur.next; 
			}
			while (cur!=null); 
			cur = next; 
			next = null; 
			prev = null; 
		}
	}

}
