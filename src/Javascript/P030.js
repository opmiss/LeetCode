/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
	var map = {};
	var num = words.length;
	var step = words[0].length;
	var totleng = step*num;
	var res = [];
	words.forEach(function(w){
        if (typeof map[w]==="undefined") map[w] =0;
        ++map[w];
								})
	for (var i=0; i<step; i++){
		var i1=i, i2=i;
		var cmap = {};
		var seen = 0;
		while (i2<=s.length-step){
			var word1 = s.substring(i1, i1+step);
			var word2 = s.substring(i2, i2+step);
			if (typeof map[word2]!=="undefined"){
				if (typeof cmap[word2]==="undefined") cmap[word2]=0;
				if (++cmap[word2]>map[word2]) {--cmap[word1]; --cmap[word2]; --seen; i1+=step;}
				else {
					++seen; i2+=step;
					if (seen===num) {res.push(i1); i1+=step; --cmap[word1]; --seen; }
				}
			}else { i2+=step; i1=i2; cmap={}; seen=0;}
		}
	}
	return res;
};