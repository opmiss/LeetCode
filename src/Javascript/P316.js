/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function(s) {
	var index = {};
	for (var i=0; i<s.length; i++){
		if (typeof index[s[i]]==="undefined"){
			index[s[i]] = [];
		}
		index[s[i]].push(i);
	}
	var keys = Object.keys(index);
	keys.sort();
	var pos = 0;
	var res = [];
loop1:
	while (Object.keys(index).length>0)
		loop2:
		for (var k=0; k<keys.length; k++){
			console.log(k);
			var cid = -1;
			if (typeof index[keys[k]]!=="undefined"){
				cid = index[keys[k]].shift();
				while (cid<pos){
					cid = index[keys[k]].shift();
				}
			}else continue;
			var add = true;
			for (var key in index){
				if (index[k]===key) continue;
				if (index[key][index[key].length-1]<cid){
					index[keys[k]].unshift(cid);
					continue loop2;
				}
			}
			delete index[keys[k]];
			res.push(keys[k]);
			pos=cid;
			continue loop1;
		}
	return res.join('');
};