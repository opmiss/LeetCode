/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
	var inv = (n<0);
	n = inv?-n:n;
	var neg = (n%2===0)?false:(x<0);
	x = (x<0)?-x:x;
	if (x<1) {x = 1/x; inv = !inv; }
	var res = 1;
	if (x>1){
		for (var i=0; i<n; i++){
			res*=x;
			if (res>Number.MAX_VALUE) break;
		}
	}
	if (neg) res = -res;
	if (inv) res = 1/res;
	return res;
};