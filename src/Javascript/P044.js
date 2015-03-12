/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
	var si=0, pi=0, star=-1, stop=-1;
	while (si<s.length){
		if (pi<p.length && (s.charAt(si)===p.charAt(pi) || p.charAt(pi)==='?')){
			si++; pi++;
		}
		else if (pi<p.length && p.charAt(pi)==='*'){
			star = pi++; stop = si;
		}
		else if (star>=0) {
			pi = star+1; si=++stop; continue;
		}
		else return false;
	}
	while (pi<p.length && p.charAt(pi)=='*') pi++;
	return (pi===p.length);
};