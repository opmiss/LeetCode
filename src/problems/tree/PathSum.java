package problems.tree;

/*
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *     1
      / \
     2   3
     
   Return 6.
 */

public class PathSum {
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
