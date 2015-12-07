/**
 * @param {number[]} nums
 * @return {number[]}
 */
var countSmaller = function(nums) {
	if (nums.length<1) return [];
	var SegmentTreeNode = function(s, e){
		this.start = s;
		this.end = e;
		this.left = null;
		this.right = null;
		this.count = 0;
	};
	var max = nums[0];
	var min = nums[0];
	nums.forEach(function(num){
        max = (max<num)?num:max;
        min = (min>num)?num:min;
							 });
	var root = new SegmentTreeNode(min, max);
	var insert = function(node, num){
		++node.count;
		if (node.start===node.end){
			return 0;
		}
		if (node.left===null){
			var mid = (node.start+node.end)>>1;
			node.left = new SegmentTreeNode(node.start, mid);
			node.right = new SegmentTreeNode(mid+1, node.end);
		}
		if (num>node.left.end){
			var res=node.left.count+insert(node.right, num);
			return res;
		}
		return insert(node.left, num);
	};
	
	var res = [];
	while (nums.length>0){
		res.unshift(insert(root, nums.pop()));
	}
	return res;
};