/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
	if (nums.length<2) return [nums];
	var n = nums.length;
	var res = [];
	for (var i=0; i<n; i++){
		var first = nums.shift();
		var subres = permute(nums);
		subres.forEach(function(p){
									 var pp = p.slice();
									 pp.push(first);
									 res.push(pp);
									 });
		nums.push(first);
	}
	
	return res;
};