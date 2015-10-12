/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    var res = [];
    nums.sort(function(a, b){return a-b;});
    var i=0;
    while (i<nums.length-2){
        var t = 0-nums[i];
        var j=i+1;
        var k=nums.length-1;
        while (j<k){
            var sum = nums[j]+nums[k];
            if (sum===t){
                res.push([nums[i], nums[j], nums[k]]);
                ++j;
                while (nums[j]===nums[j-1]) ++j;
            }else if (sum>t){
                k--;
            }else {
                j++;
            }
        }
        ++i;
        while (nums[i]===nums[i-1]) ++i;
    }
    return res;
};