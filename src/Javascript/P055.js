/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
	var reach =0;
	for (var i=0; i<nums.length; i++){
		if (reach < i) return false;
		if (reach > nums.length-2) return true;
		var cur = nums[i]+i;
		if (reach<cur) reach = cur;
	}
	return false;
};