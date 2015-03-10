/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
	candidates.sort(function(a, b){return a-b});
	var sols = [];
	var sol = [];
	solve(sols, sol, 0, candidates, target);
	return sols;
};
var solve = function(sols, sol, i, candidates, target){
	if (target===0) sols.push(sol.slice());
	if (i>=candidates.length||target<candidates[0]) return;
		//include i
	sol.push(candidates[i]);
	solve(sols, sol, i+1, candidates, target-candidates[i]);
		//not include i
	var e = sol.pop();
	while (candidates[++i]===e);
	solve(sols, sol, i, candidates, target);
};