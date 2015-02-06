/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
	if (divisor ===0 || dividend===0) return 0;
	var neg = (dividend>0)^(divisor>0);
	dividend = Math.abs(dividend); divisor = Math.abs(divisor);
	var res = 0;
	if (divisor ===1) {
		res = (neg>0)?0-dividend:dividend;
		return Math.min(res, 2147483647);
	}
	if (divisor ===2) {
		dividend=dividend>>>1;
		return (neg>0)?0-dividend:dividend;
	}
	var deduct = divisor;
	var step = 1;
	while (dividend>=divisor){
		if (dividend>=deduct){
			dividend -= deduct;
			res+=step;
			deduct+=deduct;
			step+=step;
		}else{
			deduct = deduct>>1;
			step = step>>1;
		}
	}
	return (neg>0)?(0-res):res;
}; 
