/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */

var fact = [1];
var getFact=function(n){
	if (typeof fact[n]!=="undefined") return fact[n];
	fact[n] = n*getFact(n-1);
	return fact[n];
}
var getPermutation = function(n, k) {
	var nums = [];
	for (var i=0; i<n; i++) nums[i] = i+1;
	if (k<2 || n<2) return nums.join('');
	getFact(n-1);
	k = k-1;
	var res = [];
	for (var p=n-1; p>0; p--){
		if (k>=fact[p]){
			var r = k%fact[p];
			var o = (k-r)/fact[p];
			k = r;
			res.push(nums.splice(o, 1)[0]);
		}else if (k>0){
			res.push(nums.shift());
		}
		else break;
	}
	return (res.concat(nums)).join('');
};