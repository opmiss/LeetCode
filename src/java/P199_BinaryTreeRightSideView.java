package java;
import java.util.*; 

public class P199_BinaryTreeRightSideView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		list.add(root.val);
		List<Integer> right = rightSideView(root.right), left = rightSideView(root.left);
		list.addAll(right);
		if (right.size() < left.size()) {
			for (int i = right.size(); i < left.size(); i++)
				list.add(left.get(i));
		}
		return list;
	}
}
