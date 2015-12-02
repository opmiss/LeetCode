/**
 * @constructor
 * @param {number[]} nums
 */

var NumArray = function(nums){ 
	var Node = function(s, e){
		this.start = s; this.end = e;
		this.left = null; this.right = null;
		this.val = 0;
	};
	var buildTree = function(start, end){
		if (end<start) return null; 
		var node = new Node(start, end);
		if (start===end){
			node.val = nums[start];
			return node;
		}else {
			var mid = (start+end)>>1;
			node.left = buildTree(start, mid);
			node.right = buildTree(mid+1, end);
			node.val = node.left.val + node.right.val;
			return node;
		}
	};
	var updateTree = function(node, i, inc){
		node.val+=inc;
		if (node.start===node.end) return;
		var mid = (node.start+node.end)>>1;
		if (i<=mid){
			updateTree(node.left, i, inc);
		}else{
			updateTree(node.right, i, inc);
		}
	};
	var queryTree = function(node, i, j){
		if (i<=node.start&&j>=node.end) return node.val;
		if (i>node.left.end) return queryTree(node.right, i, j);
		if (j<node.right.start) return queryTree(node.left, i, j);
		return queryTree(node.left, i, node.left.end)+ queryTree(node.right, node.right.start, j);
	} 
	var root = buildTree(0, nums.length-1);
	var self = {}; 
	self.update = function(i, val){
		if (root===null) return; 
		var inc = val-nums[i]; 
		nums[i] = val;
		updateTree(root, i, inc); 
	};
	self.sumRange = function(i, j){
		if (root===null) return 0; 
		if (i>root.end||j<root.start||i>j) return 0; 
		return queryTree(root, i, j); 
	}
	return self; 
};

 var numArray = new NumArray([1, 3, 5]);
 console.log(numArray.sumRange(0, 2));
 numArray.update(1, 2);
 console.log(numArray.sumRange(0, 2));
