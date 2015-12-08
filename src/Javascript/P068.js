/**
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
var fullJustify = function(words, maxWidth) {
	var convert = function(line, fill, maxWidth){
		var slength = maxWidth-fill+line.length;
		if (line.length===1){
			for (var i=0; i<slength; i++) line.push(' ');
			return line.join('');
		}
		var a = Math.floor(slength/(line.length-1));
		var b = slength - a*(line.length-1);
		var sb = [line[0]];
		for (var i=1; i<line.length; i++){
			if (i>b) for (var k=0; k<a; k++) sb.push(' ');
			else for (var k=0; k<a+1; k++) sb.push(' ');
			sb.push(line[i]);
		}
		return sb.join('');
	};
	
	var convertLast = function(line, fill, maxWidth){
		if (fill>maxWidth) return line.join(' ');
		var sb = [];
		for (var i = 0; i<line.length; i++){
			sb.push(line[i]);
			sb.push(' ');
		}
		var num = maxWidth-fill;
		for (var i=0; i<num; i++) sb.push(' ');
		return sb.join('');
	};
	var res = [];
	var line = [];
	var fill = 0;
	for (var i=0; i<words.length; i++){
		if (fill+words[i].length<=maxWidth){
			line.push(words[i]);
			fill+=words[i].length+1;
		}
		else {
			res.push(convert(line, fill, maxWidth));
			line = [];
			line.push(words[i]);
			fill = words[i].length+1;
		}
	}
	res.push(convertLast(line, fill, maxWidth));
	return res;
};