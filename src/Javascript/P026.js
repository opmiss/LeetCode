/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
	var b=0;
	for (var i=1; i<nums.length; i++){
		if (nums[i]!==nums[b]){
			nums[++b] = nums[i];
		}
	}
	return b+1;
};