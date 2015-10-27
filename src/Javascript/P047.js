/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
	var permute = function(nums) {
		if (nums.length<2) return [nums];
		for (var i=1; i<nums.length; i++){
			if (nums[i]!==nums[i-1]) break;
		}
		if (i>=nums.length) return [nums];
		var n = nums.length;
		var res = [];
		for (i=0; i<n; i++){
			var first = nums.shift();
			if (first!==nums[nums.length-1]){
				var subres = permute(nums);
				subres.forEach(function(p){
											 var pp = p.slice();
											 pp.push(first);
											 res.push(pp);
											 })
			}
			nums.push(first);
		}
		return res;
	};
	nums.sort();
	return permute(nums);
};