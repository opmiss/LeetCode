/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function(intervals) {
	if (intervals.length<2) return intervals;
	intervals.sort(function(a, b){return a.start-b.start;});
	var int = intervals[0];
	var res = [];
	for (var i=1; i<intervals.length; i++){
		if (int.end < intervals[i].start){
			res.push(int);
			int = intervals[i];
		}else {
			int.end = Math.max(intervals[i].end, int.end);
		}
	}
	res.push(int);
	return res;
};