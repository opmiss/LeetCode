/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
	var left=nums.length, right=-1;
	var find = function(s, e){
		if (s>e) return;
		if (target<nums[s]||target>nums[e]) return;
		if (nums[s]===target && nums[e]===target){
			left = (left<s)?left:s;
			right = (right<e)?e:right;
			return;
		}
		var m = (s+e)>>1;
		if (nums[m]===target){
			left = (left<m)?left:m;
			right = (right<m)?m:right;
			find(s, m-1);
			find(m+1, e);
		}else if (nums[m]>target){
			find(s, m-1);
		}else {
			find(m+1, e);
		}
	}
	find(0, nums.length-1);
	left = (left===nums.length)?-1:left;
	return [left, right];
};