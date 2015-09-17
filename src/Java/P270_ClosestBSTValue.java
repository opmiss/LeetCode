package Java;
import java.util.*;

public class P270_ClosestBSTValue {
	class TreeNode{
		int val; 
		TreeNode left, right; 
		TreeNode(int v){
			val=v; 
		}
	}
	public int closestValue(TreeNode root, double target) {
		double closest = Integer.MAX_VALUE;
	    int value = 0;
	    TreeNode current = root;
	    while (current != null) {
	        if (closest > Math.abs(current.val-target)) {
	            closest = Math.abs(current.val-target);
	            value = current.val;
	        }

	        if (current.val < target) {
	            current = current.right;
	        } else if (current.val > target) {
	            current = current.left;
	        } else {
	            break;
	        }
	    }
	    return value; 
	}
	//Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
	public List<Integer> closestKValues(TreeNode root, final double target, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
        	@Override
        	public int compare(Integer a, Integer b){
        		double db= Math.abs((double)b-target); 
        		double da = Math.abs((double)a-target);
        		if (db>da) return 1; 
        		else if (db<da) return -1; 
        		else return 0; 
        	}
        });
        addToHeap(root, heap, target, k);
        return new ArrayList<Integer>(heap);
	}
	public void addToHeap(TreeNode node, Queue<Integer> heap, final double target, int capacity) {
        if(node == null) return;
        if (heap.size()<capacity) heap.add(node.val); 
        else if (Math.abs(node.val-target) < Math.abs(heap.peek()-target)){
        	heap.poll(); 
        	heap.add(node.val); 
        }
        addToHeap(node.left, heap, target, capacity);
        addToHeap(node.right, heap, target, capacity);
    } 
	
	public TreeNode recover(String input) {
		if (input.length() == 0 || input.charAt(0) == '*')
			return null;
		TreeNode root = new TreeNode(input.charAt(0)-'0');
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int i = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (++i >= input.length())
				return root;
			if (input.charAt(i) != '*') {
				cur.left = new TreeNode(input.charAt(i)-'0');
				queue.add(cur.left);
			}
			if (++i >= input.length())
				return root;
			if (input.charAt(i) != '*') {
				cur.right = new TreeNode(input.charAt(i)-'0');
				queue.add(cur.right);
			}
		}
		return root;
	}
	
	public static void main(String[] args){
		P270_ClosestBSTValue p = new P270_ClosestBSTValue(); 
		TreeNode root = p.recover("42513*6"); 
		System.out.println(p.closestKValues(root, 3.55, 3)); 
		
	}
}
