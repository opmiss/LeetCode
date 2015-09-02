package java;

import java.util.ArrayList;
import java.util.Stack;

import problems.tree.TreeNode;

public class P144_BinaryTreePreorderTraversal {
	 public static ArrayList<Integer> preorderTraversal(TreeNode root) {
			ArrayList<Integer> list = new ArrayList<Integer>(); 
			if (root == null) return list; 
			Stack<TreeNode> stack = new Stack<TreeNode>(); 
			stack.push(root); 
			while (!stack.isEmpty()){
				TreeNode cur = stack.pop(); 
				list.add(cur.val); 
				if (cur.right!=null) {stack.push(cur.right); }
				if (cur.left!=null) {stack.push(cur.left); }
			}
			return list; 
	    }

}
