package java;
import java.util.*;
public class P257_BinaryTreePaths {
	class TreeNode{
		int val; 
		TreeNode left, right; 
		TreeNode(int v){
			val=v; 
		}
	}
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
