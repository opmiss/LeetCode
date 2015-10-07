package java;
import java.util.*;
import com.leetcode.problems.tree.*;

public class P173_BSTIterator {
	Stack<TreeNode> stack; 

    public P173_BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>(); 
        TreeNode cur = root; 
        while (cur!=null) {
            stack.push(cur); 
            cur=cur.left; 
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty(); 
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop(); 
        TreeNode cur = n.right; 
        while (cur!=null){
            stack.push(cur); 
            cur=cur.left; 
        }
        return n.val; 
    }

}
