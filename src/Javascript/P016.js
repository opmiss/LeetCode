/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    if (nums.length<3) return 0;
    nums.sort(function(a, b){return a-b});
    var res = nums[0]+nums[1]+nums[2];
    if (nums.length===3) return res;
    for (var i=0; i<nums.length-2; i++){
        var st = target-nums[i];
        var j = i+1, k=nums.length-1;
        while (j<k){
            var sum = nums[j]+nums[k];
            if (Math.abs(st-sum)<Math.abs(res-target)) res = sum+nums[i];
            if (sum<st) j++;
            else if (sum>st) k--;
            else return target;
        }
    }
    return res;
};