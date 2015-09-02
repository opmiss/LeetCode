package java;
import java.util.*; 

import problems.tree.*;

public class P145_BinaryTreePostorderTraversal {
	public static ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		if (root == null) return list; 
	    Stack<TreeNode> stack = new Stack<TreeNode>(); 
		stack.push(root); 
		TreeNode prev = root; //previously inserted into the list
		TreeNode cur = root; //current top of the stack
		while (!stack.isEmpty()){
			cur = stack.peek(); 
			if (cur.left == prev || cur.right==prev){
			    list.add(stack.pop().val); 
			    prev = cur; 
			}
			else{ 
				if (cur.right==null && cur.left==null){
					list.add(stack.pop().val); 
					prev = cur; 
				}
				else{
					if (cur.right!=null) stack.push(cur.right); 
					if (cur.left!=null)  stack.push(cur.left); 
				}
			}
		}
		return list; 
	}

}
