/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    nums.sort(function(a, b){return a-b});
    var res = [];
    for (var i=0; i<nums.length-3&&target>=nums[i]*4; i++){
        if (i>0&&nums[i]===nums[i-1]) continue;
        for (var j=i+1; j<nums.length-2&&target>=nums[i]+nums[j]*3; j++){
            if (j>i+1 && nums[j]===nums[j-1]) continue;
            var st = target-nums[i]-nums[j];
            var k = j+1;
            var l = nums.length-1;
            while (k<l){
                var sum = nums[k]+nums[l];
                if (sum>st) l--;
                else if (sum<st) k++;
                else {
                    res.push([nums[i], nums[j], nums[k], nums[l]]);
                    --l; while (nums[l]===nums[l+1]) --l;
                }
            }
        }
    }
    return res;
};