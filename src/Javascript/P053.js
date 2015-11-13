/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
	var sum = Number.NEGATIVE_INFINITY, maxsum = sum;
	nums.forEach(function(num, i){
        sum = (sum<0)?num:(sum+num);
        maxsum = (maxsum<sum)?sum:maxsum;
							 })
	return maxsum;
};