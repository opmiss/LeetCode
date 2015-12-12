/**
 * @param {string[]} words
 * @return {number}
 */
var maxProduct = function(words) {
	var mask = [];
	for (var i=0; i<words.length; i++){
		var m = 0;
		for (var j = 0; j<words[i].length; j++){
			m = m|(1<<(words[i].charCodeAt(j)-97));
		}
		mask.push(m);
	}
	console.log(mask)
	var res = 0;
	for (var i=0; i<mask.length-1; i++){
		for (var j=i+1; j<mask.length; j++){
			if ((mask[i]&mask[j])===0){
				var l = words[i].length*words[j].length;
				res = (res<l)?l:res;
			}
		}
	}
	return res;
};