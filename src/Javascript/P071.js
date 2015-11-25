/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
	var parts = path.split("/");
	var stack = [];
	for (var i=0; i<parts.length; i++){
		if (parts[i].length<1||parts[i]==='.') continue;
		if (parts[i]==='..'){
			if (stack.length>0) stack.pop();
		}
		else stack.push(parts[i]);
	}
	return '/'+stack.join("/");
};