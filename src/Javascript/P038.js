/**
 * @param {number} n
 * @return {string}
 */
var cache = [];
cache[1] = '1';
var countAndSay = function(n) {
	if (typeof cache[n]!=="undefined") return cache[n];
	var b = countAndSay(n-1);
	var c = 1;
	var ch = b[0];
	var s = '';
	for (var i=1; i<b.length; i++){
		if (b[i]===b[i-1]) c++;
		else {
			s+=[c, ch].join('');
			c=1;
			ch = b[i];
		}
	}
	s+=[c, ch].join('');
	return s;
};