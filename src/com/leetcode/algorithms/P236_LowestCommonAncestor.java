package com.leetcode.algorithms;
import com.leetcode.problems.tree.*;

public class P236_LowestCommonAncestor {
	class DataNode {
        boolean hasP; 
        boolean hasQ; 
        DataNode left; 
        DataNode right; 
        DataNode(){hasP=false; hasQ=false;}
    }
    public DataNode create(TreeNode node, TreeNode p, TreeNode q){
        if (node == null) return null; 
        DataNode dnode = new DataNode(); 
        dnode.hasP = (node==p);
        dnode.hasQ = (node==q); 
        dnode.left = create(node.left, p, q); 
        dnode.right = create(node.right, p, q); 
        if (dnode.left!=null){
            dnode.hasP = (dnode.left.hasP||dnode.hasP); 
            dnode.hasQ = (dnode.left.hasQ||dnode.hasQ); 
        }
        if (dnode.right!=null){
            dnode.hasP = (dnode.right.hasP||dnode.hasP); 
            dnode.hasQ = (dnode.right.hasQ||dnode.hasQ); 
        }
        return dnode; 
    }
    public TreeNode search(TreeNode node, DataNode dnode){
        if (dnode.hasP&&dnode.hasQ){ 
            if (dnode.left!=null&&dnode.left.hasP&&dnode.left.hasQ) {
                return search(node.left, dnode.left); 
            }
            else if (dnode.right!=null&&dnode.right.hasP&&dnode.right.hasQ) {
                return search(node.right, dnode.right); 
            }
            else {
                return node;
            }
        }
        else return null; 
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DataNode droot = create(root, p, q); 
        return search(root, droot); 
    }
}
