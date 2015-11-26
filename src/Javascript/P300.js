/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
	if (nums.length<2) return nums.length;
	var leng = [];
	for (var i=0; i<nums.length; i++){
		leng[i]=1;
		for (var j=0; j<i; j++){
			if (nums[i]>nums[j]&&leng[i]<=leng[j]){
				leng[i] = leng[j]+1;
			}
		}
	}
	return Math.max.apply(this, leng);
};