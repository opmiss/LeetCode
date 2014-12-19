package com.leetcode.problems.tree;

import java.util.Stack;

/* 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
*/

public class BinaryTreePreorderInorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
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
