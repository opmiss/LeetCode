/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function(n, edges){
		//preprocess the edges
	var nb = [];
	var degree = [];
	for (var i=0; i<n; i++) { nb[i]=[]; degree[i]=0;}
	edges.forEach(function(e){
        ++degree[e[0]];
        ++degree[e[1]];
        nb[e[0]].push(e[1]);
        nb[e[1]].push(e[0]);
								});
	var visiting = [];
	var visitnext = [];
	degree.forEach(function(d, i){
								 if (d===1) visiting.push(i);
								 });
	while (visiting.length>0){
		visitnext=[];
		visiting.forEach(function(n){
										 for (var b in nb[n]){
										 if (--degree[nb[n][b]]===1) visitnext.push(nb[n][b]);
										 }
										 });
		if (visitnext.length>0){
			visiting = visitnext;
		}else return visiting;
	}
	return [0];
};