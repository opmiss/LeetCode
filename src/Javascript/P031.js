/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
	if (nums.length<2) return;
	var i = nums.length-1;
	while (i>0 && nums[i]<=nums[i-1]) {
		i--;
	}
	var p = i-1, t;
	var j = nums.length-1;
	while (i<j){
		t = nums[j];
		nums[j] = nums[i];
		nums[i] = t;
		i++; j--;
	}
	if (p<0) return;
	for (i=p+1; i<nums.length; i++){
		if (nums[p]<nums[i]){
			t = nums[p];
			nums[p] = nums[i];
			nums[i] = t;
			break;
		}
	}
};