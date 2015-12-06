/**
 * @param {number[]} nums
 * @return {number}
 */
var maxCoins = function(nums) {
	nums.unshift(1);
	nums.push(1);
	var cache = nums.map(function(n){return [];});
	var burst = function(left, right){
		if (left+1>=right) return 0;
		if (typeof cache[left][right]!=="undefined") return cache[left][right];
		var res = 0;
		for (var i=left+1; i<right; i++){
			var subres = nums[left]*nums[i]*nums[right]+burst(left, i)+burst(i, right);
			res = (res<subres)?subres:res;
		}
		cache[left][right] = res;
		return res;
	};
	return burst(0, nums.length-1);
};