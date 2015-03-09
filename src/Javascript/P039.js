/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
	sols = [];
	sol = [];
	candidates.sort(function(a, b){return a-b});
	solve(sols, sol, 0, candidates, target);
	return sols;
};
var solve=function(sols, sol, i, candidates, target){
	if (target===0) sols.push(sol.slice());
	if (i>=candidates.length||target<candidates[i]) return;
		//include i
	sol.push(candidates[i]);
	solve(sols, sol, i, candidates, target-candidates[i]);
		//not include i
	sol.pop();
	solve(sols, sol, i+1, candidates, target);
}
