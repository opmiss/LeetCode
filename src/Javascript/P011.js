/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    var left = 0;
    var right = height.length-1;
    var maxa = 0;
    while (left <right){
        maxa = Math.max(maxa, Math.min(height[left], height[right])*(right-left));
        if (height[left]<height[right]) left++;
        else right--;
    }
    return maxa;
};