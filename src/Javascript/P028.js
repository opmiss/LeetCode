/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
	for (var i=0; i<=haystack.length-needle.length; i++){
		var k=0;
		for (; k<needle.length; k++){
			if (haystack[i+k]!==needle[k]) break;
		}
		if (k===needle.length) return i;
	}
	return -1;
};