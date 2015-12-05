/**
 * @param {number} n
 * @param {number[]} primes
 * @return {number}
 */
var nthSuperUglyNumber = function(n, primes) {
	var ugly = [1];
	var index = primes.map(function(p){return 0;});
	var candidates = primes.map(function(p){return p;});
	for (var i=1; i<n; i++){
		ugly[i] = Number.MAX_VALUE;
		var j;
		for (j=0; j<primes.length; j++){
			ugly[i] = (ugly[i]>candidates[j])?candidates[j]:ugly[i];
		}
		for (j=0; j<primes.length; j++){
			if (ugly[i]===candidates[j]){
				++index[j];
				candidates[j] = ugly[index[j]]*primes[j];
			}
		}
	}
	return ugly[n-1];
};