/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var add = function(a1, a2){
	if (a1.length===0) return a2;
	var res = [];
	var i=0, c =0, sum =0;
	while (i<a1.length&&i<a2.length){
		sum = a1[i]+a2[i]+c;
		res.push(sum%10);
		c = (sum>9)?1:0;
		i++;
	}
	while (i<a1.length){
		sum = a1[i]+c;
		res.push(sum%10);
		c = (sum>9)?1:0;
		i++;
	}
	while (i<a2.length){
		sum = a2[i]+c;
		res.push(sum%10);
		c = (sum>9)?1:0;
		i++;
	}
	if (c>0) res.push(1);
	return res;
};
var multiply = function(num1, num2) {
	if (num1==="0"||num2==="0") return "0";
	var res = [0];
	for (var i=num2.length-1; i>=0; i--){
		if (num2[i]==='0') continue;
		var ni = num2[i].charCodeAt(0)-48, carry=0;
		var m = [];
		for (var k=i; k<num2.length-1; k++) m.push(0);
		for (var j=num1.length-1; j>=0; j--){
			var nj = num1[j].charCodeAt(0)-48;
			var t = ni*nj+carry;
			m.push(t%10);
			carry = Math.floor(t/10);
		}
		if (carry>0) m.push(carry);
		res = add(res, m);
	}
	res.reverse();
	return res.join('');
};