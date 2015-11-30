/**
*@constructor
*@param {number[]} nums
*/
var NumArray = function(nums){ 
	this.sum = [0]; 
	for (var i=0; i<nums.length; i++){
		this.sum[i+1]=this.sum[i]+nums[i]; 
	} 
}; 

NumArray.prototype.sumRange = function(i, j){
	return this.sum[j+1]-this.sum[i]; 
}; 

var numArray = new NumArray([-1, 0, 3, 5, 2]);
console.log(numArray.sumRange(0, 1)); 
