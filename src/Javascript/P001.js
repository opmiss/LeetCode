var twoSum = function(nums, target){
	var table={}; 
	var res = []; 
	for (var i=0; i<nums.length; i++){
		if (typeof table[target-nums[i]]!="undefined"){
			res=[1+table[target-nums[i]], 1+i]; 
			return res; 
		}
		table[nums[i]]=i; 
	}
	return res; 
}; 
