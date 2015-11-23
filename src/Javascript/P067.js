/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
	var i = a.length-1;
	var j = b.length-1;
	var sum = [];
	var carry =0;
	var s;
	while (i>=0&&j>=0){
		s=Number(a[i])+Number(b[j])+carry;
		if (s>1){
			s = s%2;
			carry = 1;
		} else carry=0;
		sum.push(s);
		i--; j--;
	}
	while (i>=0){
		s = Number(a[i])+carry;
		if (s>1){
			s = 0; carry=1;
		} else carry =0;
		sum.push(s);
		i--;
	}
	while (j>=0){
		s = Number(b[j])+carry;
		if (s>1){
			s=0; carry=1;
		} else carry =0;
		sum.push(s);
		j--;
	}
	if (carry>0) sum.push(1);
	sum.reverse();
	return sum.join('');
};