/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
	var find = function(nums, s, e){
		if (s>e) return -1;
		if (nums[s]===target) return s;
		if (nums[e]===target) return e;
		if (s===e||s+1===e) return -1;
		var m = (s+e)>>1;
		if (nums[m]===target) return m;
		if (nums[s]<nums[e]){
			if (nums[m] > target) return find(nums, s+1, m-1);
			else return find(nums, m+1, e-1);
		}else {
			if (nums[s]<nums[m]) {
				if (target<nums[m] && target>nums[s]) return find(nums, s+1, m-1);
				else return find(nums, m+1, e-1);
			}
			else {
				if (target>nums[m] && target<nums[e]) return find(nums, m+1, e-1);
				else return find(nums, s+1, m-1);
			}
		}
	}
	return find(nums, 0, nums.length-1);
};
