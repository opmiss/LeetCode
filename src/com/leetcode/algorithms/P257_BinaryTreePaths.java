package com.leetcode.algorithms;
import java.util.*;
import com.leetcode.problems.tree.*;

public class P257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null)
			return res;
		List<String> leftpaths = binaryTreePaths(root.left);
		for (String lp : leftpaths) {
			res.add(root.val + "->" + lp);
		}
		List<String> rightpaths = binaryTreePaths(root.right);
		for (String rp : rightpaths) {
			res.add(root.val + "->" + rp);
		}
		if (leftpaths.isEmpty() && rightpaths.isEmpty())
			res.add("" + root.val);
		return res;
	}

}
