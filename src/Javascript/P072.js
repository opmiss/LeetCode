/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
	var p0 = [];
	for (var i=0; i<=word2.length; i++) p0[i] = i;
	var p1 = [];
	for (var i1=0; i1<word1.length; i1++){
		p1[0] = i1+1;
		for (var i2=0; i2<word2.length; i2++){
			p1[i2+1] = (p1[i2]<p0[i2+1])?(p1[i2]+1):(p0[i2+1]+1);
			if (word1[i1]===word2[i2]){
				p1[i2+1] = (p0[i2]<p1[i2+1])?p0[i2]:p1[i2+1];
			}else {
				p1[i2+1] = (p1[i2+1]<p0[i2]+1)?p1[i2+1]:(p0[i2]+1);
			}
		}
		p0 = p1;
		p1 =[];
	}
	return p0[word2.length];
};