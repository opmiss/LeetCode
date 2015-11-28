/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function(s) {
	s = s.trim();
	var p = s.split('e');
	if (p.length>2) return false;
	if (/^[+-]?[0-9]+([.][0-9]*)?$/.test(p[0])||/^[+-]?[0-9]*[.][0-9]+$/.test(p[0])){
		if (p.length<2) return true;
		return /^[+-]?[0-9]+$/.test(p[1]);
	}
	return false;
};