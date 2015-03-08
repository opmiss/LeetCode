/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
	for (var i=0; i<nums.length; i++){
		if (nums[i]>0 && nums[i]<=nums.length && nums[i]!==i+1 && nums[i]!==nums[nums[i]-1]){
			var p = nums[i]-1;
			var t = nums[i];
			nums[i] = nums[p];
			nums[p] = t;
			i--;
		}
	}
	i=0; while (nums[i]===(i+1)) i++;
	return i+1;
};