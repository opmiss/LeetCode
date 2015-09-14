package java;


public class P124_MaxTreePathSum {
	/*
	 * Given two words (start and end), and a dictionary, 
	 * find all shortest transformation sequence(s) from start to end, such that:
	 * Only one letter can be changed at a time
	 * Each intermediate word must exist in the dictionary
	 * For example, given:
	 * start = "hit"
	 * end = "cog"
	 * dict = ["hot","dot","dog","lot","log"]
	 * Return:
	 * [
	 * 	["hit","hot","dot","dog","cog"],
	 * 	["hit","hot","lot","log","cog"]
	 * ]
	 * */
	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	  public int maxPathSum(TreeNode root) {
	    	maxSum=Integer.MIN_VALUE; 
	        sideSum(root); 
	        return maxSum; 
	    } 
	    int maxSum=Integer.MIN_VALUE; 
	    public int sideSum(TreeNode node){
	    	if (node==null) return 0; 
	    	int leftSum = sideSum(node.left); 
	    	int rightSum = sideSum(node.right); 
	    	int ret = (leftSum<rightSum)?rightSum:leftSum;
	    	ret = (ret<0)?node.val:(ret+node.val); 
	    	int sum = leftSum+rightSum+node.val; 
	     	maxSum = (maxSum<ret)?ret:maxSum; 
	     	maxSum = (maxSum<sum)?sum:maxSum; 
	    	return ret; 
	    }

}
