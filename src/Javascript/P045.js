/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
	var step = 0, last = 0, cur = 0, reach = 0;
	for (var i=0; i<nums.length; i++){
		if (last<i){
			++step;
			last = reach;
			if (last>=nums.length-1) return step;
		}
		cur = i+nums[i];
		if (reach<cur){
			reach = cur;
		}
	}
	return step;
};