/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
	var i = s.length-1;
	while (s[i]===' ') i--;
	var r = i;
	for (; i>=0; i--){
		if (s[i]===' ') break;
	}
	return r-i;
};