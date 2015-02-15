/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
	var stack = [];
	var maxl = 0, l;
	for (var i=0; i<s.length; i++){
		if (s[i]==='(') stack.push(s[i]);
		else if (stack.length<1) {
			continue;
		}
		else {
			var e = stack.pop();
			l = 0;
			while (e!=='('){
				l+=e;
				if (stack.length<1) break;
				e = stack.pop();
			}
			if (e==='(') {
				l+=2;
				stack.push(l);
			}else {
				maxl = (maxl<l)?l:maxl;
			}
		}
	}
	l=0;
	for (i=0; i<stack.length; i++){
		if (stack[i]!=='('){
			l+=stack[i];
			maxl = (maxl<l)?l:maxl;
		}else {
			l=0;
		}
	}
	return maxl;
};
