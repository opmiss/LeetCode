/**
 * @param {number} n
 * @return {number}
 */
var bulbSwitch = function(n) {
	var res = 0;
	for (var i=1; i<=n; i++){
		var num = Math.floor(Math.sqrt(i));
		if (num*num === i) ++res;
	}
	return res;
};