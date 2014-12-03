package com.leetcode.problems.tree;

import java.util.Stack;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
*/

public class BinaryTreeInorderPostorder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
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
}
