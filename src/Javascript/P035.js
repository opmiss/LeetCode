/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
	var find = function(s, e){
		if (s>e) return s;
		if (target<=nums[s]) return s;
		if (target===nums[e]) return e;
		if (target>nums[e]) return e+1;
		var m = (s+e)>>1;
		if (target===nums[m]) return m;
		if (target>nums[m]) return find(m+1, e-1);
		return find(s+1, m-1);
	}
	return find(0, nums.length-1);
};