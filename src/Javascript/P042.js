/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
	var plank = 0, v=0, i=0, j = height.length-1;
	while (i<j){
		if (height[i]<height[j]){
			if (plank < height[i]){
				plank = height[i];
			}else{
				v+=plank-height[i];
			}
			i++;
		}else{
			if (plank<height[j]){
				plank = height[j];
			}else{
				v+=plank-height[j];
			}
			j--;
		}
	}
	return v;
};