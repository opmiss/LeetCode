package Java;
import java.util.*;

public class P106_ConstructBST {
	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	/*
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	*/
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// inorder: LMR, postorder LRM
		if (inorder.length == 0 || inorder.length != postorder.length)
			return null;
		int n = inorder.length;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		stack.push(root);
		TreeNode node = null, cur = root;
		int i = n - 1, j = n - 1;
		while (i >= 0) {
			if (stack.peek().val == inorder[i]) {
				node = stack.pop();
				i--;
			} else if (node != null) {
				cur = new TreeNode(postorder[j]);
				node.left = cur;
				node = null;
				stack.push(cur);
				j--;
			} else {
				cur = new TreeNode(postorder[j]);
				stack.peek().right = cur;
				stack.push(cur);
				j--;
			}
		}
		return root.right;
	}
	
	/* 
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	*/
	
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		if (inorder.length == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		stack.push(root);
		int i = 0, j = 0;
		TreeNode node = null;
		TreeNode cur = root;
		while (j < inorder.length) {
			if (stack.peek().val == inorder[j]) {
				node = stack.pop();
				j++;
			} else if (node != null) {
				cur = new TreeNode(preorder[i]);
				node.right = cur;
				node = null;
				stack.push(cur);
				i++;
			} else {
				cur = new TreeNode(preorder[i]);
				stack.peek().left = cur;
				stack.push(cur);
				i++;
			}
		}
		return root.left;
	}
}
