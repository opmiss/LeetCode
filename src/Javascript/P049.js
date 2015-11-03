/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
	var map = {};
	strs.forEach(function(str){
        var key = str.split('').sort().join('');
        if (typeof map[key]==="undefined") map[key]=[];
        map[key].push(str);
							 });
	var res = [];
	for (var key in map){
		res.push(map[key].sort());
	}
	return res;
};