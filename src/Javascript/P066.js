/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
	if (digits.length<1) return [1];
	var carry=(++digits[digits.length-1]>9)?1:0;
	digits[digits.length-1] = digits[digits.length-1]%10;
	for (var i=digits.length-2; i>=0; i--){
		if (carry<1) break;
		digits[i] +=carry;
		carry = (digits[i]>9);
		digits[i] = digits[i]%10;
	}
	if (carry>0) digits.unshift(1);
	return digits;
};
